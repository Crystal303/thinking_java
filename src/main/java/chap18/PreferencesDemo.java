package chap18;

import java.util.prefs.Preferences;

/**
 * Preferences API 用于存储和读取用户的偏好以及配置项的配置
 * 只能存储基本类型和字符串
 *
 * @author crystal303
 */
public class PreferencesDemo {
    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches", true);
        int usageCount = prefs.getInt("UsageCount", 0);
        ++usageCount;
        prefs.putInt("UsageCount", usageCount);
        for (String key:
             prefs.keys()) {
            System.out.println(key + ": " + prefs.get(key,null));
        }

        System.out.println("How many companions does Dorothy have? " + prefs.getInt("Companions",0));
    }
}
