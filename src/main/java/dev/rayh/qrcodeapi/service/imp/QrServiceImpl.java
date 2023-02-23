package dev.rayh.qrcodeapi.service.imp;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import dev.rayh.qrcodeapi.QrRequest;
import dev.rayh.qrcodeapi.service.QrService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class QrServiceImpl implements QrService {
    @Override
    public byte[] getQrCode(QrRequest text, Optional<Integer> width) throws WriterException, IOException {

        int dim = width.orElse(200);
        /*
        * verifing if dim is greather then 1080, if true, set dim to limit 1080
        * */
        if (dim > 1080){
            dim = 1080;
        }


        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix;
        BufferedImage bufferedImage;


        //making a QR code
        try{
             bitMatrix = writer.encode(text.getText(), BarcodeFormat.QR_CODE, dim, dim);
             bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        }catch (WriterException exception){
            throw new WriterException();
        }

        //converting to byte[] and returning
        return toArrayByte(bufferedImage);
    }

    private byte[] toArrayByte(BufferedImage bufferedImage) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "PNG", baos);
        return baos.toByteArray();
    }
}
