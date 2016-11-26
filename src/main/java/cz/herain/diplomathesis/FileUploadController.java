package cz.herain.diplomathesis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import javax.portlet.ActionResponse;
import java.util.Iterator;

@Controller
@RequestMapping("VIEW")
public class FileUploadController {

    @ActionMapping(value = "submitFile")
    public void submitFoo(MultipartRequest actionRequest, ActionResponse actionResponse) {
        Iterator<String> fileNames = actionRequest.getFileNames();
        MultipartFile file = actionRequest.getFile(actionResponse.getNamespace() + "file");
        //save file here
    }

    public static class FileBean {
        private CommonsMultipartFile fileData;

        public CommonsMultipartFile getFileData() {
            return fileData;
        }

        public void setFileData(CommonsMultipartFile fileData) {
            this.fileData = fileData;
        }
    }
}
