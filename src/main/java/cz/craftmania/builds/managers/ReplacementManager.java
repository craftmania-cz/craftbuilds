package cz.craftmania.builds.managers;

public class ReplacementManager {

    public static String replaceText(String message) {
        if (message.contains("o/")) {
            return message.replaceAll("o/", "( ﾟ◡ﾟ)/");
        }
        if (message.contains("<3")) {
            return message.replaceAll("<3", "§c❤");
        }
        if (message.contains(":star:")) {
            return message.replaceAll(":star:", "§6✮");
        }
        if (message.contains(":shrug:")) {
            return message.replaceAll(":shrug:", "¯\\_(ツ)_/¯");
        }
        if (message.contains(":tableflip:")) {
            return message.replaceAll(":tableflip:", "(╯°□°）╯︵ ┻━┻");
        }
        if (message.contains(":unflip:")) {
            return message.replaceAll(":unflip:", "┬─┬ ノ( ゜-゜ノ)");
        }
        if (message.contains(":fight:")) {
            return message.replaceAll(":fight:", "(ง'̀-'́)ง");
        }
        if (message.contains(":lenny:")) {
            return message.replaceAll(":lenny:", "( ͡° ͜ʖ ͡°)");
        }
        if (message.contains(":moneypls:")) {
            return message.replaceAll(":moneypls:", "(づ｡◕‿‿◕｡)づ");
        }
        if (message.contains(":*")) {
            return message.replaceAll(":*", "(づ￣ ³￣)づ");
        }
        if (message.contains(":hype:")) {
            return message.replaceAll(":hype:", "ヾ(⌐■_■)ノ♪");
        }
        if (message.contains(":cry:")) {
            return message.replaceAll(":cry:", "(ಥ﹏ಥ)");
        }
        return message;
    }
}
