package aprivate.mo.tide.Message;

/**
 * Created by Mo on 2020/6/6
 */

public class UpdateUserMessage {

    private String objID;

    public UpdateUserMessage(String objID) {
        this.objID = objID;
    }

    public String getObjID() {
        return objID;
    }

    public void setObjID(String objID) {
        this.objID = objID;
    }
}
