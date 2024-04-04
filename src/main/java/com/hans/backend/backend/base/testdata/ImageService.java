package com.hans.backend.backend.base.testdata;

import com.hans.backend.backend.appl.actors.service.dto.Player;
import com.hans.backend.backend.appl.teams.service.dto.Team;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@Service
@AllArgsConstructor
public class ImageService {

    private static String facesDirectoryPath = "dummydata/faces";
    private static File facesDirectory = new File(facesDirectoryPath);
    private static File[] facesFiles = facesDirectory.listFiles();


    public Player addPlayerImage(Player dto, Integer counter) {  // gewoon om wat data te hebben.
        if(facesFiles != null) {
            if(counter > 20){  // gewoon om wat data te hebben.
                counter = 1;
            }
            try {
                byte[] faceData = IOUtils.toByteArray(new FileInputStream(facesFiles[counter]));
                String base64FaceData = Base64.getEncoder().encodeToString(faceData);
                dto.setPlayerImageData(base64FaceData);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

        return dto;

    }


}
