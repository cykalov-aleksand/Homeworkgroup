package sky.group.homeworkgroup.exception;

public class WhenNumberNotEqualOne extends RuntimeException{
    public WhenNumberNotEqualOne(){
        super("Число пользователей в базе данных не равно единице");

    }
}
