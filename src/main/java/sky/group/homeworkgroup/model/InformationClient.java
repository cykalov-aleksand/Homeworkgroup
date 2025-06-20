package sky.group.homeworkgroup.model;

import java.util.Objects;
import java.util.UUID;

public class InformationClient {
    private UUID id;
    private UUID user_id;
    private String typeTransaction;
    private long amountTransaction;
    private String typeProduct;
    private String nameProduct;

    private final String debit;
    private final String deposit;
    private final int i;


    public InformationClient(String debit, String deposit, int i) {
        super();
        this.debit = debit;
        this.deposit = deposit;
        this.i = i;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public long getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(long amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof InformationClient that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
