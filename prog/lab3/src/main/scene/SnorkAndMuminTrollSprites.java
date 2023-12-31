package main.scene;

import main.scene.nodes.SpriteNode;
import main.render.structs.IntVector2;
import main.render.structs.SpriteData;

public class SnorkAndMuminTrollSprites extends SpriteNode {

    public SnorkAndMuminTrollSprites(IntVector2 pos) {
        super(SPRITE_1);
        setLocalPosition(pos);
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
