class Solutionx1 {
    public long minimumTime(int[] time, int totalTrips) {
        int low =1;
        int high = time[0];
        for (int i = 1; i < time.length; i++) {
                high = Math.max(high,time[i]);
        }

        while(low<high){
            int mid = low+(high-low)/2;
            long tar = giveSumToN(time, totalTrips, mid);
            if(tar>=totalTrips){
                high=mid;
            }else{
                low=mid+1;
            }
        }

        return high;
        
    }

    long giveSumToN(int [] time,int totalTrips,long k){
        long sum = 0;
        for(int i=0;i<time.length;i++){
            sum+= (k/time[i]);
        }
        return sum;
    }
    public static void main(String[] args) {

        int len = 6;
        int arr[] = {1,3,5,7,9};
        int totalTrips = 10;
        Solutionx1 s=new Solutionx1();
        System.out.println(s.minimumTime(arr, totalTrips));
    }
}