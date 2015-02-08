package {
import com.adobe.cairngorm.control.FrontController;
import com.izerui.commond.GetServerConfigsCommond;
import com.izerui.commond.RemoveServerConfigCommond;
import com.izerui.commond.SaveServerConfigCommond;

public class Controller extends FrontController {

    public function initialize():void {
        this.addCommand("getServerConfigs", GetServerConfigsCommond);
        this.addCommand("saveServerConfig", SaveServerConfigCommond);
        this.addCommand("removeServerConfig", RemoveServerConfigCommond);
    }

    public function Controller() {
        this.initialize();
    }
}
}