package uz.gc.alator.creator.service.project;

import org.springframework.stereotype.Service;
import uz.gc.alator.creator.dto.response.ResponseDto;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ProcessLauncher {

    public ResponseDto<Void> launchJar(String jarFilePath, String projectName){
        String command = String.format("java -Dspring.application.name=%s -jar %s", projectName, jarFilePath);

        try {
            Process process = Runtime.getRuntime().exec(command);
            return new ResponseDto<Void>()
                    .setSuccess(true)
                    .setMessage("OK");
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseDto<Void>()
                    .setMessage(e.getMessage());
        }
    }

    public ResponseDto<Void> stopJar(int port) {
        String command = "java --version";
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "--version");
//            pb.directory(new File())
            pb.redirectErrorStream(true);

            Process process = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            process.waitFor();

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseDto<Void>()
                .setMessage("OK")
                .setSuccess(true);
    }
}
