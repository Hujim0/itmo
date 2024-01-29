package application.sceneNodes;

import application.extensions.*;
import engine.structs.IntVector2;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SnorkAndMuminTrollSprites extends SpriteNode {

    public SnorkAndMuminTrollSprites(IntVector2 pos) {
        super(SPRITE_1);
        setLocalPosition(pos);
    }

    @Override
    public void treeEnter() {
        setVisible(false);

        addAction(4, (object) -> {
            setVisible(true);
        });
        addAction(5, (obj) -> {
            SnorkAndMuminTrollSprites instance = (SnorkAndMuminTrollSprites) obj;

            instance.setSprite(SnorkAndMuminTrollSprites.SPRITE_2);
            instance.setLocalPosition(new IntVector2(0, 0));
        });
        addAction(6, (obj) -> {
            SnorkAndMuminTrollSprites instance = (SnorkAndMuminTrollSprites) obj;

            instance.setSprite(SnorkAndMuminTrollSprites.SPRITE_3);
        });
        addAction(7, (obj) -> {
            obj.setActive(false);
        });
    }
    public static final SpriteData SPRITE_1 = new SpriteData(
            new IntVector2(12,3),
            new char[][] {
            "  0<       0".toCharArray(),
            "  |~      _\\".toCharArray(),
            " / \\      -~".toCharArray()
    });

    public static final SpriteData SPRITE_2 = new SpriteData(
            new IntVector2(76,42),
            new char[][] {

            "           ......-.........................+--.........+++++.........+..... ".toCharArray(),
            "        ..+----+#-...++++++++++-.............++#+.......#++++++#......++..+.".toCharArray(),
            "     .----....-----+++.......+++++++++++++-..++#++.......+++++++++...-+++++.".toCharArray(),
            "   .--.------.--###--#+..............+++#+#+++++##+-......+++++++++..+++..- ".toCharArray(),
            "  . .---+--------------##+......-........-++######+++.++...#+++++++..++#+.--".toCharArray(),
            "   .--------------+##.#----##.................-++##+++++++...++++++..++#++..".toCharArray(),
            "  .. ...-...-+.+-+-+-...##++##-..................++++++++++++++++++#.++##+..".toCharArray(),
            "       ..  .............  -+..--. +.....-...........+#+++++##+++++++.++#++..".toCharArray(),
            "  .        ............-        .-......----....-.....++++++++#+++++.++#++- ".toCharArray(),
            "         ............ +         +.....-----+---..----+++++++++++++++.+###+-.".toCharArray(),
            "         ........... /          ......-..---------........+++#+++++..+###+..".toCharArray(),
            "            .... ...-    _   _ +-.....-...---..--------.....++###+++++++++-.".toCharArray(),
            "          .      ... #  / . /.  ..............-.......----...++###++++++#+..".toCharArray(),
            "         .  .... ..|         _  #.......................-.....++##+++####+..".toCharArray(),
            "       ..    ......              ...........-............--....+#########+..".toCharArray(),
            "           ....../               +.-..............+ -...........+####+###+..".toCharArray(),
            "             ....    \\              +.............+#\\-...-.-..-..+###+###+. ".toCharArray(),
            "     ... .......+                    -......../ +--.  \\....-......+###+#++..".toCharArray(),
            "          .  ../      .. ~ ~        ...............- . \\...........++####+-.".toCharArray(),
            "         ......         -#- __.-_.+-........./.+.-.+    \\..........+++##++-.".toCharArray(),
            "        . .  ..     /    ###    ~............|-....+      ..........#++##+- ".toCharArray(),
            "          ..       /    # .      ~......---.-|-~~~~~.#     |.........####++-".toCharArray(),
            "             |          |  |      \\...........            - \\.......+###+++-".toCharArray(),
            "           . .              |     |..........| -T. ~T.   .  #......+##++++-.".toCharArray(),
            "           . .                    ~..........           .#   #..-..+##+##+- ".toCharArray(),
            "             |                    |.......~?             #   ++....+#+###+-.".toCharArray(),
            "                                 /....../       /~~++   /  .  ....-+#####+-.".toCharArray(),
            "            .                    ~......|     ~~#     +#       -..++#####+- ".toCharArray(),
            "    ....---....                 ~.......-        |      #      .+.++###+++-.".toCharArray(),
            " ....---------\\                 ~........+-       \\      +-   .  ++######+-.".toCharArray(),
            " ..............|         #.    |.+--###+-..+~~~~~+ #       ##    -#######+-.".toCharArray(),
            "        .......        ..#     ~........----+       \\        .    #######+-.".toCharArray(),
            " .            .-     -..|     /-#------+###..        .            -######+..".toCharArray(),
            "  ..    ........      /..\\___/--..-------...-          .          .######+..".toCharArray(),
            "        .........~~~~~-------------.-------.-                   .  ++####+-.".toCharArray(),
            " .........-----------.----------------#.....-                      #-++#+++.".toCharArray(),
            "..........------------+####--------.--+ +## --  ..                 --#.-..+.".toCharArray(),
            "..-.----..-----------------------.----.      .  -.   +#            + ##-#-#.".toCharArray(),
            "........-..-------.---...--------.----.      -- # ++.              + #+##-#.".toCharArray(),
            " .-----------------------------....----        +#  ++             . #---#-#.".toCharArray(),
            "...---.----------------------------------~~~~~~~+  ++   #+--+## #  #------#.".toCharArray(),
            "...--------------------------------------------.+  ++  -        ##----+---#.".toCharArray(),
            ".-------#----------------------------------------------+  .    +--------+-#-".toCharArray()
    });

    public static final SpriteData SPRITE_3 = new SpriteData(
            new IntVector2(72,31),
            new char[][]{
                    "                             .:--   .:-..    :-.                        ".toCharArray(),
                    "                            :.=.. .=:+-=-.  :.=.                        ".toCharArray(),
                    "        -#.    =..   .-*. .-:.-:...=:-.::-  ....    -#.                 ".toCharArray(),
                    "      .*:++*.. :*#==:-=#-....:..    ..:=.....-::  .=**-                 ".toCharArray(),
                    "       =+#:=*###+#=#*:-.        .   -.::..-.:=-.: :##=.#%+*-.           ".toCharArray(),
                    "         -#%%#%%%%%##=.      ...   .-.-:=:=:=:=:=-=*.#%%##%%%: .:..     ".toCharArray(),
                    "        .#%%%%%%%%%#-       .-.~. ..-.+:-:+::=::-.::#%%.  .-%#+-=..     ".toCharArray(),
                    "        .#%#%#%%%%#..       | *@...@%.-+:~~-..@...-.+%%%####%%....      ".toCharArray(),
                    "     .. .*#%#%%%%#...        .~~~.-.=-.- %@  -.=.:..--:=-%#===*=        ".toCharArray(),
                    "     .+*+######%*.  ..              .|  ..~~       .+#=**#-:*-.         ".toCharArray(),
                    "     :-**#*+*=#+:   :.               .               ==%#++#%##*.       ".toCharArray(),
                    "     .-*#*+-..-:.   .:                 \\             -%%%%%%%%%=.       ".toCharArray(),
                    "    .*##*+=:..-.     .-                 ..             =%%%%%%%%%.      ".toCharArray(),
                    "    .*+=++++++:       .-.                .             +%%%%%%%#%*-     ".toCharArray(),
                    "     .+###*#*+          .:.            .:.           .-.+######+=**.    ".toCharArray(),
                    "     -++--#**:            .:..       .:..::.      ..:.::-.=+:=*+.       ".toCharArray(),
                    "      .-++-++.               ..:---:..      .......    :--#*-:--...     ".toCharArray(),
                    "      .+##*#=                       ...-=.              .++......+#*:   ".toCharArray(),
                    "      -*..:=.                     .::..=----.            .:.:::..-.     ".toCharArray(),
                    "     .-:.:::                .:::...     -==-.             --.:.:::      ".toCharArray(),
                    "      :::::=.                         ...-=.:             .##+=:...     ".toCharArray(),
                    "      ..--##.                     ..-...     =.            :+*#+.-:     ".toCharArray(),
                    "     .+#+#**=               ..--..===....+.   :.       .:-.:.:..:.:.    ".toCharArray(),
                    "     :.:..-::.              .-..     .:   .    .-=-.   ...-..:==: --.   ".toCharArray(),
                    "    .:.:.:.:-.            ..          -   :.:...-=-:...=  .  .=-. :==.. ".toCharArray(),
                    "     .--..:.=-                 .     .-   .   .=--..  .:  .  .==..----: ".toCharArray(),
                    "       :-...::-.              ..     .    ...            .--==++++-=*-: ".toCharArray(),
                    "          :*#***-.. .=...    ..       ..-.. ..=-::=*-.:.--+++--=++=-::. ".toCharArray(),
                    "         .:.::..-***+-. ....:-=-::::----=-=:.  .===--:--*-+==+-=--:...  ".toCharArray(),
                    "             .=***#*:.+*#+--=--=-:::-:-:+--.  .:::==:..........         ".toCharArray(),
                    "               ... ..--.....:::::-=:--:--=------:..                     ".toCharArray()
            });
}
