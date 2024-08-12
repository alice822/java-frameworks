import java.util.Arrays;

public class ScanDiskScheduling {
    public static void main(String[] args) {
        int[] requests = { 98, 183, 37, 122, 14, 124, 65, 67 };
        int head = 53;
        int totalSeekTime = scanDisk(requests, head);
        System.out.println("Total seek time using SCAN: " + totalSeekTime);
    }

    public static int scanDisk(int[] requests, int head) {
        Arrays.sort(requests);

        int totalSeekTime = 0;
        int previousRequest = 0;
        int direction = (head < requests[0]) ? -1 : 1; // -1 for moving left, 1 for moving right

        int index = 0;
        for (int i = 0; i < requests.length; i++) {
            if (direction == 1 && requests[i] > head) {
                index = i;
                break;
            } else if (direction == -1 && requests[i] >= head) {
                index = i - 1;
                break;
            }
        }

        if (direction == 1) {
            for (int i = index; i < requests.length; i++) {
                totalSeekTime += Math.abs(requests[i] - previousRequest);
                previousRequest = requests[i];
            }
            totalSeekTime += Math.abs(previousRequest - requests[requests.length - 1]);
            totalSeekTime += Math.abs(requests[requests.length - 1] - requests[0]);
        } else {
            for (int i = index; i >= 0; i--) {
                totalSeekTime += Math.abs(requests[i] - previousRequest);
                previousRequest = requests[i];
            }
            totalSeekTime += Math.abs(previousRequest - requests[0]);
            totalSeekTime += Math.abs(requests[0] - requests[requests.length - 1]);
        }

        return totalSeekTime;
    }
}
