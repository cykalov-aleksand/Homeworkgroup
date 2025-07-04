package sky.group.homeworkgroup.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель выдачи данных о системе внешнему пользователю")
public class InfoBuild {
    private String name;
    private String version;

    public InfoBuild() {
    }

    public InfoBuild(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
