class Solution {
    /**
    문제: arr1을 정렬하되, arr2의 배열 순서를 유지해야한다.
    arr1의 element는 반드시 arr2의 element를 한번 이상 포함하는 조건을 가지고 있으니, arr2의 element를 arr1에서 몇개를 갖고 있는지 map으로 기록한 다음에 정렬을 수행하면 될 것 같다.

    1. arr2룰 순회하여 map의 keySet을 형성
    2. arr1을 순회하여 arr2의 element는 각각 몇개씩 가지고 있는지 확인
    3. arr2에는 없는 element는 따로, list를 선언하여 담는다.
    4. 정답을 출력할 result list를 선언하여 arr2를 순회하여 map에서 기록한 횟수만큼 list에 담는다.
    5. arr1에서 arr2에는 포함되지 않았던 element를 정렬하여 result list에 마저 담는다.
    6. result list를 배열로 변환하여 리턴한다.
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr2) {
            map.put(val, 0);
        }

        List<Integer> remains = new ArrayList<>();
        for (int val : arr1) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                remains.add(val);
            }
        }
        Collections.sort(remains);

        List<Integer> list = new ArrayList<>();
        for (int val : arr2) {
            int cnt = map.get(val);
            while (cnt > 0) {
                list.add(val);
                cnt--;
            }
        }
        list.addAll(remains);

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}