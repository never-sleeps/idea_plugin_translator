import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("ConstantConditions")
public class TranslateAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);

        if (editor.getSelectionModel().getSelectedText() != null) {
            String selectedText = editor.getSelectionModel().getSelectedText();
            String encoded = "";
            try {
                encoded = URLEncoder.encode(selectedText, StandardCharsets.UTF_8.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String url = String.format("https://translate.google.com/?hl=ru&sl=en&tl=ru&text=%s&op=translate", encoded);
            BrowserUtil.browse(url);
        } else {
            Messages.showMessageDialog("Selection is empty", "Translate Plugin", Messages.getWarningIcon());
        }
    }

    @Override
    public boolean isDumbAware() {
        return false;
    }
}
