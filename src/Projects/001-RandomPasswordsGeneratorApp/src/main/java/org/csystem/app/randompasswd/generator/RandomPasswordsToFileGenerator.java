package org.csystem.app.randompasswd.generator;

import org.csystem.util.string.StringUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.stream.LongStream;

public class RandomPasswordsToFileGenerator {
    private final Path m_path;
    private final long m_n;
    private final int m_min;
    private final int m_max;
    private final Random m_random;

    private void writeFileCallback(BufferedWriter bw)
    {
        try {
            bw.write(StringUtil.getRandomTextTR(m_random, m_random.nextInt(m_max - m_min + 1) + m_min) + "\r\n");
            bw.flush();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public RandomPasswordsToFileGenerator(String path, long n, int min, int max)
    {
        this(Path.of(path), n, min, max);
    }

    public RandomPasswordsToFileGenerator(Path path, long n, int min, int max)
    {
        m_path = path;
        m_n = n;
        m_min = min;
        m_max = max;
        m_random = new Random();
    }

    public void run() throws IOException
    {
        try (var bw = Files.newBufferedWriter(m_path, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
            LongStream.range(0, m_n).forEach(i -> writeFileCallback(bw));
        }
    }
}
