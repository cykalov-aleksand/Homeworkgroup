package sky.group.homeworkgroup.model.modeljbd;

import java.util.UUID;

public class InformationClient {
    private UUID id;
    private UUID userId;
    private String typeTransaction;
    private long amountTransaction;
    private String typeProduct;
    private String nameProduct;


    public InformationClient() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

}
