class Solution {
    /**
    주어진 스케쥴에서 미팅 일정이 없는 날을 카운팅하는 함수 구현
    -> 시작 시간을 기준으로 미팅 일정을 정렬하고 순회하며 겹치지 않는 구간을 찾아 미팅 일정이 없는 날짜를 찾는다.
    
    겹치지 않는 구간
    현재 미팅 일정의 끝 시간이 다음 일정의 시작 시간보다 작으면 된다.
    이 구간을 찾아서 '다음 일정[1] - 이전 일정[1] - 1'을 수행하면, 미팅이 없는 일정의 일수가 카운팅된다.
    
    마지막으로, 마지막 일정의 종료시간이 주어진 days와 일치한지 확인하여 마지막으로 미팅 없는 일정을 카운팅한다.

    실수1. 시작시간은 동일하지만, 종료시간이 동일하지 않은 meetings 일정은 고려하지 않았다.
    실수2. 시작시간이 1일을 포함하지 않을수도 있다는 점을 간과했다.
    실수3. 일정이 시작 시간 기준으로 정렬되었지만, 종료시간이 들쑥날쑥함으로 merge interval 과정이 필요했다는걸 깜빡함
    -> 만약 merged interval을 모르면 56번 문제 https://leetcode.com/problems/merge-intervals/description/ 참고
     */
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int count = 0;

        List<int[]> mergedMeetings = merge(meetings);

        int[] first = mergedMeetings.get(0);
        if (first[0] > 1) {
            count += first[0] - 1;
        }

        for (int i = 0; i < mergedMeetings.size() - 1; i++) {
            int[] current = mergedMeetings.get(i);
            int[] next = mergedMeetings.get(i + 1);

            if (current[1] < next[0]) {
                count += next[0] - current[1] - 1;
            }
        } 

        int[] last = mergedMeetings.get(mergedMeetings.size() - 1);
        if (last[1] < days) {
            count += days - last[1];
        }

        return count;
    }

    private List<int[]> merge(int[][] meetings) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < meetings.length;) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            i++;
            while (i < meetings.length && end >= meetings[i][0]) {
                end = Math.max(end, meetings[i][1]);
                i++;
            }
            result.add(new int[]{start, end});
        }

        return result;
    }
}