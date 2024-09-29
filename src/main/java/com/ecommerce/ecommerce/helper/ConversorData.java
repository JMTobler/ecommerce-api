package com.ecommerce.ecommerce.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {
    public static String converteDateParaDataEHora(Date data) {
        return new SimpleDateFormat("YYYY-MM-ddTHH:mm:ss").format(data);
    }
}

