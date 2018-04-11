public class Test {
    public static void main(String[] args){
        String a = "0029029720999991901072213004+60450+022267FM-12+001499999V0200201N001019999999N0000001N9+03171+99999101681ADDGF101991999999999999999999";
        String q = a.substring(88,93);
        System.out.println(q);
        System.out.println(q.matches("[01459]"));
    }
}
