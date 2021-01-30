package exception;

public class ExceptionApiDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");

        try {
            String str="abc";
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            String message=e.getMessage();
            System.out.println(message);
        }

        System.out.println("程序结束了");
    }
}
