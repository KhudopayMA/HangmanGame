public class Drawer {
    private static final String[] pictures = {
                """
                    ┌─────
                    │    │
                    │
                    │
                    │
                    │
                    └─────""",
                """
                    ┌─────
                    │    │
                    │    O
                    │
                    │
                    │
                    └─────""",
                """
                    ┌─────
                    │    │
                    │    O
                    │    |
                    │
                    │
                    └─────""",
                """
                    ┌─────
                    │    │
                    │    O
                    │   /|
                    │
                    │
                    └─────""",
        """
                    ┌─────
                    │    │
                    │    O
                    │   /|\\
                    │
                    │
                    └─────""",
        """
                    ┌─────
                    │    │
                    │    O
                    │   /|\\
                    │   /
                    └─────""",
        """
                    ┌─────
                    │    │
                    │    O
                    │   /|\\
                    │   / \\
                    └─────"""};

    public static void draw(int mistake){
        System.out.println(pictures[mistake]);
    }
}
