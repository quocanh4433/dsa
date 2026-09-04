import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BuildReadme {

    public static void main(String[] args) {
        Path currentDir = Paths.get(".");
        StringBuilder markdownBuilder = new StringBuilder();

        // Header bang Markdown
        markdownBuilder.append("| Num | Name | Topic | Pattern | Solution |\n");
        markdownBuilder.append("| :---: | -------- | -------- | -------- | -------- |\n");

        int totalProblems = 0;

        try {
            // Tim tat ca cac file .json trong thu muc hien tai
            List<Path> jsonFiles = Files.list(currentDir)
                    .filter(path -> path.toString().endsWith(".json"))
                    .sorted()
                    .collect(Collectors.toList());

            if (jsonFiles.isEmpty()) {
                System.out.println("[!] Khong tim thay file .json nao trong thu muc!");
                return;
            }

            for (Path filePath : jsonFiles) {
                String content = Files.readString(filePath);
                
                // Trich xuat cac JSON Object {...} bang Regex
                Pattern objectPattern = Pattern.compile("\\{[^\\}]+\\}");
                Matcher matcher = objectPattern.matcher(content);

                while (matcher.find()) {
                    totalProblems++; // Tang so thu tu
                    
                    // Dinh dang Num thanh 3 chu so (VD: 1 -> 001, 12 -> 012)
                    String numStr = String.format("%03d", totalProblems);
                    
                    String jsonObjectStr = matcher.group();

                    String name = extractJsonValue(jsonObjectStr, "name");
                    String link = extractJsonValue(jsonObjectStr, "leetcode_link");
                    String topic = extractJsonValue(jsonObjectStr, "topic");
                    String pattern = extractJsonValue(jsonObjectStr, "pattern").trim();
                    String solution = extractJsonValue(jsonObjectStr, "solution");

                    String nameCell = !link.isEmpty() ? "[" + name + "](" + link + ")" : name;
                    String solCell = !solution.isEmpty() ? "[Link](" + solution + ")" : "";

                    // In dòng với Num dạng 001, 012, 100,...
                    markdownBuilder.append(String.format("| %s | %s | %s | %s | %s |\n",
                            numStr, nameCell, topic, pattern, solCell));
                }
            }

            // Ghi du lieu ra file README.md
            Files.writeString(Paths.get("README.md"), markdownBuilder.toString());
            System.out.println("[+] Da tao file README.md thanh cong voi " + totalProblems + " bai tap!");

        } catch (IOException e) {
            System.err.println("[-] Loi khi xu ly file: " + e.getMessage());
        }
    }

    private static String extractJsonValue(String json, String key) {
        Pattern pattern = Pattern.compile("\"" + key + "\"\\s*:\\s*\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}