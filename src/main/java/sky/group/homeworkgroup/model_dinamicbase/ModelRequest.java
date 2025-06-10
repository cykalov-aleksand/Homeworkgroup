package sky.group.homeworkgroup.model_dinamicbase;

public class ModelRequest {
    private String query;
    private String argumentFirst;
    private String argumentSecond;
    private String operation;
    private int number;
    private Boolean negate;

    public ModelRequest(String query, String argumentFirst, String argumentSecond, String operation, int number, Boolean negate) {
        this.query = query;
        this.argumentFirst = argumentFirst;
        this.argumentSecond = argumentSecond;
        this.operation = operation;
        this.number = number;
        this.negate = negate;
    }
    public ModelRequest(String query, String argumentFirst,Boolean negate){
        this.query = query;
        this.argumentFirst = argumentFirst;
        this.argumentSecond =null;
        this.operation = null;
        this.number = 0;
        this.negate = negate;
    }
    public ModelRequest(String query,String argumentFirst,String operation,Boolean negate){
        this.query = query;
        this.argumentFirst = argumentFirst;
        this.argumentSecond =null;
        this.operation = operation;
        this.number = 0;
        this.negate = negate;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getArgumentFirst() {
        return argumentFirst;
    }

    public void setArgumentFirst(String argumentFirst) {
        this.argumentFirst = argumentFirst;
    }

    public String getArgumentSecond() {
        return argumentSecond;
    }

    public void setArgumentSecond(String argumentSecond) {
        this.argumentSecond = argumentSecond;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Boolean getNegate() {
        return negate;
    }

    public void setNegate(Boolean negate) {
        this.negate = negate;
    }
}
