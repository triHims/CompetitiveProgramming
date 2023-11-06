class CountInversion
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        mergeSort(arr,0,(int)(N));
        for(long l:arr){
            System.out.printf("%d ",l);
        }
        System.out.println(" ");
        return 5;
        
    }
    
    // int totalArr1 = mid-start+1;
    //     int totalArr2 = end-mid+1;
    //     int midOfTotal = total/2;
    
    static void merge(long arr[],int start,int mid,int end){
        long temp[] = new long[mid-start+end-mid];
        int seek = 0;
        
        int startTemp = start;
        int midTemp = mid;
        
        while(startTemp<mid && midTemp<end){
            if(arr[startTemp]<=arr[midTemp]){
                temp[seek++] = arr[startTemp++];
            }else{
                temp[seek++]=arr[midTemp++];
            }
        }
        
        while(startTemp<mid){
            temp[seek++]=arr[startTemp++];
        }
        
        while(midTemp<end){
            temp[seek++]=arr[midTemp++];
        }
        
        
        seek = 0;
        
        for(int i = start;i<end;i++){
            arr[i]=temp[seek++];
        }
        
        
        
    }
    
    
    static void mergeSort(long arr[] ,int start,int end){
        System.out.println("Start  end -"+start+" "+end);
        if(end-start<2){
            return;
        }
        else{
            int mid = (end-start)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid,end);
            merge(arr,start,mid,end);
        }
        
    }

    public static void main(String args[]){
        long arr[] = {2,1,4};
        inversionCount(arr,3);
    }

}
