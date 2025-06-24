package sky.group.homeworkgroup.model;

public class StaticRuleModel {
    private long ruleId;
    private int count;
    public StaticRuleModel(){}

    public StaticRuleModel(long ruleId, int count) {
        this.ruleId = ruleId;
        this.count = count;
    }

    public long getRuleId() {
        return ruleId;
    }

    public void setRuleId(long ruleId) {
        this.ruleId = ruleId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
