package dev.rayh.qrcodeapi.service;

import com.google.zxing.WriterException;
import dev.rayh.qrcodeapi.QrRequest;

import java.io.IOException;
import java.util.Optional;

public interface QrService {

    byte[] getQrCode(QrRequest text, Optional<Integer> width) throws WriterException, IOException;
}
