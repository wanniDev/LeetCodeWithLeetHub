class Solution {
    private static class People {
        int id;
        String name;
        int height;

        public People(int id, String name, int height) {
            this.id = id;
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        List<People> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new People(i, names[i], heights[i]));
        }
        list.sort((o1, o2) -> o2.height - o1.height);

        return list.stream().map(a -> a.name.toString()).toArray(String[]::new);
    }
}