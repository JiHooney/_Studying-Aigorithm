package implementation;

import java.util.ArrayList;
import java.util.Collections;

class Result {
    int stage;
    double failure;

    Result( int stage, double failure ) {
        this.stage = stage;
        this.failure = failure;
    }
}

public class Pro42889 {
    public static void main(String[] args) {
        //첫번째 케이스
        int N = 8;
        //int[] stages = {2,1,2,6,2,4,3,3};
        //int[] stages = {4,4,4,4,4};
        int[] stages = {1, 2, 3, 4, 5, 6, 7};
        
        int[] players = new int[N+2];   //1~최종 단계까지 완료한 사람 담기위해 N+2
        int[] alls = new int[N+1];      //각 Stage에 도달한 전체 유저수
        
        for( int i=0; i<stages.length; i++ ) players[stages[i]]++;
        
        //각 스테이지를 도달한&완료한 유저수 구하기
        //이때 N번째 스테이지는 N번째 도달한 유저 + N+1도달한 유저
        alls[N] = players[N] + players[N+1];
        for( int i=N-1; i>=1; i-- ) {
            alls[i] = players[i] + alls[i+1];
        }
        
        //arraylist에 스테이지와 실패율 저장
        ArrayList<Result> arr = new ArrayList<>();
        for( int i=1; i<=N; i++ ) {
            //스테이지에 도달한 유저 없는 경우 실패율은 0
            if( alls[i]==0 ) {
                arr.add( new Result(i, 0) );
                continue;
            }
            
            double rate = (double)players[i]/alls[i];
            arr.add( new Result(i, rate) );
        }
        
        //실패율 높은 순으로 정렬
        Collections.sort(arr, ( (o1, o2) -> Double.compare(o2.failure, o1.failure) ) );
        
        //정렬된 실패율의 스테이지 번호 저장
        int[] answer = new int[N];
        for( int i=0; i<arr.size(); i++ ) {
            answer[i] = arr.get(i).stage;
        }
        
    }
}
