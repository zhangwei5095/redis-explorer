package {
import com.adobe.cairngorm.control.FrontController;
import com.izerui.commond.GetDbAmountCommond;
import com.izerui.commond.GetKeysCommond;
import com.izerui.commond.GetServerConfigsCommond;
import com.izerui.commond.RemoveServerConfigCommond;
import com.izerui.commond.SaveServerConfigCommond;

public class Controller extends FrontController {

    public function initialize():void {
        this.addCommand("getServerConfigs", GetServerConfigsCommond);
        this.addCommand("saveServerConfig", SaveServerConfigCommond);
        this.addCommand("removeServerConfig", RemoveServerConfigCommond);
        this.addCommand("getDbAmount", GetDbAmountCommond);
        this.addCommand("getKeys", GetKeysCommond);
    }

    public function Controller() {
        this.initialize();
    }
}
}