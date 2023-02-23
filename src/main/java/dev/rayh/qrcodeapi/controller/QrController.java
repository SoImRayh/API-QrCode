package dev.rayh.qrcodeapi.controller;

import com.google.zxing.WriterException;
import dev.rayh.qrcodeapi.QrRequest;
import dev.rayh.qrcodeapi.service.QrService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/qrcode")
@RequiredArgsConstructor
@CrossOrigin("*")
public class QrController {

    private final QrService service;

    @PostMapping(value = "", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getQrCode(
            @RequestBody QrRequest text,
            @PathParam("width") Optional<Integer> width
    ) throws IOException, WriterException {
        return service.getQrCode(text, width);
    }

}
