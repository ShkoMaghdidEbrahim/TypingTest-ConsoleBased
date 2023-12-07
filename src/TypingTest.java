import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.function.Consumer;

public class TypingTest {
    static String difficulty = "";
    
    public TypingTest() {
        Scanner s = new Scanner(System.in);
    
        DecimalFormat formatter = new DecimalFormat();
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        formatter.setPositiveSuffix("%");
        boolean repeatOuter = true;
        boolean chosenCorrectly = false;
    
        System.out.println("Hi, Welcome " + Main.username + "\nThis is a simple Typing Test");
        //Text sample to be re-formated
        String[] Easy = new String[]{"the", "of", "and", "a", "to", "in", "is", "you", "that", "it", "he", "was", "for", "on", "are", "as", "with", "his", "they", "I", "at", "be", "this", "have", "from", "or", "one", "had", "by", "word", "but", "not", "what", "all", "were", "we", "when", "your", "can", "said", "there", "use", "an", "each", "which", "she", "do", "how", "their", "if", "will", "up", "other", "about", "out", "many", "then", "them", "these", "so", "some", "her", "would", "make", "like", "him", "into", "time", "has", "look", "two", "more", "write", "go", "see", "number", "no", "way", "could", "people", "my", "than", "first", "water", "been", "call", "who", "oil", "its", "now", "find", "long", "down", "day", "did", "get", "come", "made", "may", "part"};
        String[] Medium = new String[]{"accommodate", "accommodated", "accommodates", "accommodating", "accommodatingly", "accommodation", "accommodationism", "accommodationist", "accommodations", "accommodative", "accompanied", "accompanies", "accompaniment", "accompaniments", "accompanist", "accompanists", "accompany", "accompanying", "accompanyist", "accompanyists", "accomplice", "accomplices", "accomplish", "accomplished", "accomplisher", "accomplishes", "accomplishing", "accomplishment", "accomplishments", "accord", "accordance", "accordant", "accorded", "according", "accordingly", "accordion", "accordionist", "accordionists", "muscatels", "muscats", "muscid", "muscle", "musclebound", "muscled", "muscleman", "musclemen", "muscles", "muscling", "muscly", "muscovado", "muscular", "muscularity", "hijacked", "hijacker", "hijackers", "hijacking", "hijackings", "hijacks", "hike", "hiked", "hiker", "hikers", "hikes", "hiking", "hila", "hilarious", "hilariously", "hilariousness", "hilarity", "hill", "hillbillies", "keyboarders", "keyboarding", "keyboardist", "keyboardists", "keyboards", "keycard", "keyed", "keyhole", "keyholes", "keying", "keynote", "keynoted", "keynoter", "keynoters", "keynotes", "keynoting", "keypad", "keypads", "keypunch", "keypunched", "keypuncher", "keypunchers", "keypunches", "keypunching", "keyring", "keys", "keystone", "keystones", "outguessing", "outgun", "outgunned", "outgunning", "outguns", "out-haul", "outhit", "outhits", "outhitting", "outhouse", "outhouses", "outing", "outings", "outlaid", "out-land", "outlander", "outlanders", "outlandish", "outlandishly", "outlandishness", "outlands", "outlast", "outlasted", "outlasting", "outlasts", "outlaw", "outlawed", "outlawing", "outlawries", "beeps", "beer", "beerier", "beeriest", "beermat", "beermats", "beers", "beery", "bees", "bees-tings", "beeswax", "bowing", "beet", "beetle", "beetled", "beetles", "beetling", "beetroot", "beetroots", "beets", "beeves", "beer", "befall", "befallen", "befalling", "befalls", "befell", "befit", "befits", "befitted", "befitting", "befittingly", "befog", "befogged", "muscularly", "musculature", "muse", "mused", "musicology", "muster", "muses", "musette", "musettes", "museum", "museums", "mush", "mushed", "musher", "mushers", "mushes", "mushier", "mushiest", "mushiness", "mushing", "mushroom", "mushroomed", "revivalism", "revivalist", "revivalist", "revivalists", "revivals", "revive", "revived", "reviver", "revives", "revivification", "revivified", "revivifies", "revivify", "revivifying", "reviving", "reminiscence", "revocable", "revocation", "revocations", "revelatory", "voice", "revoke", "revoked", "revoker", "revokers", "revokes", "revoking", "revolt", "revolted", "revolted", "revolting", "revoltingly", "revolts", "revolute", "revolution", "revolutionaries", "revolutionary", "revolution", "revolutionist", "revolutionists", "revolutions", "revolvable", "revolve", "revolved", "revolver", "revolvers", "workweeks", "workman", "world", "worldlier", "worldliest", "worldliness", "worldliness", "worldly", "worlds", "worldview", "worldviews", "worldwide", "worm", "wormed", "wormhole", "wormholes", "wormier", "wormiest", "worthiness", "worming", "worms", "worm-seed", "saprophytes", "hypertrophic", "kerosene", "sclerosis", "xerox", "xeroxed", "xeroxes", "xeroxing", "xi", "magisterium", "subxiphoid", "xis", "xu", "xylem", "xylene", "xylene", "sliding", "holograph", "holography", "reload", "xy lol", "axolotls", "coprophagous", "xylophone", "xylophones", "xylophonist", "xylophonists", "dichotomous", "lobotomy", "oyster", "yeast", "yeastier", "yeastiest", "yeasts", "yeasty", "yegg", "yeggs", "yield", "yell", "yelled", "yelling", "yellow", "yellow bird", "yellow-birds", "yellowed", "yellower", "yellowest", "yellowhammer", "yellowhammers", "yellowing", "yellowish", "yellowness", "yellowness", "yellows", "yellow tail", "eline", "Tibet", "cloudiness", "invidiousness", "zig", "ziggurat", "zips", "zigzag", "zigzagged", "zigzagged", "zigzagging", "zigzags", "zilch", "zillion", "zillions", "zinc", "zinc-ate", "coniferous", "zincked", "zincking", "iconographic", "iconography", "zincs", "zine", "zines", "zinfandel", "zing", "roaring", "desegregated", "desegregates", "desegregating", "desegregation", "desegregationist", "deselect", "deselected", "deselecting", "deselection", "deselects", "desert", "deserted", "deserter", "deserters", "desertification", "deserting", "desertion", "desertions", "deserts", "deserve", "deserved", "deservedly", "deserves", "deserving", "deserving", "des-ex", "folktale", "folktales", "folkway", "folkways", "follicle", "follicles", "follicular", "follicular", "follies", "follow", "followed", "follower", "followers", "following", "followings", "follows", "folly", "foment", "fomentation", "fomented", "fomented", "fomenters", "fomenting", "foments"};
        String[] Hard = new String[]{"A,", "I.", "His,", "That?", "He.", "Was?", "For.", "On,", "Are,", "With,", "They!", "Be;", "At.", "One.", "Have.", "This,", "From,", "By;", "Hot!", "Word,", "But:", "What,", "Some.", "Is.", "It,", "You!", "Or.", "Had;", "The,", "Of!", "To.", "And,", "A:", "In.", "We;", "Can,", "Out?", "Other?", "Were!", "Which,", "Do.", "Their?", "Time.", "If.", "Will.", "How,", "Said,", "An,", "Each,", "Tell,", "Does.", "Set.", "Three.", "Want;", "Air?", "Well!", "Also,", "Play,", "Small,", "End,", "Put?", "Home;", "Read,", "Hand;", "Port.", "Large.", "Spell,", "Add,", "Even.", "Land.", "Here?", "Must,", "Big.", "High,", "Such.", "Follow!", "Act!", "Why.", "Ask,", "Men,", "Change,", "Went,", "Light,", "Kind,", "Off,", "Need,", "House,", "Picture?", "Try,", "Us,", "Again,", "Animal,", "Point,", "Mother.", "World,", "Near,", "Build.", "Self.", "Earth,", "Father,", "Any.", "New,", "Work.", "Part,", "Take;", "Get,", "Place.", "Made,", "Live,", "Where.", "After,", "Back:", "Little,", "Only,", "Round,", "Man.", "Year?", "Came;", "Show;", "Every,", "Good!", "Me;", "Give,", "Our,", "Under.", "Name,", "Very!", "Through.", "Just.", "Form.", "Sentence,", "Great,", "Think.", "Say,", "Help!", "Low,", "Line!", "Differ,", "Turn,", "Cause,", "Much.", "Mean.", "Before,", "Move,", "Right;", "Boy?", "Old,", "Too;", "Same?", "She;", "All!", "There,", "When,", "Up,", "Use,", "Your,", "Way,", "About,", "Many,", "Then,", "Them,", "Write!", "Would.", "Like,", "So,", "These!", "Her,", "Long,", "Make;", "Thing,", "See;", "Him,", "Two:", "Has.", "Look,", "More,", "Day,", "Could,", "Go!", "Come,", "Did,", "Number.", "Sound.", "No,", "Most,", "People,", "My,", "Over,", "Know,", "Water,", "Than?", "Call!", "First.", "Who,", "May.", "Down,", "Side?", "Been,", "Now?", "Find.", "Head,", "Stand,", "Own,", "Page,", "Should,", "Country?", "Found.", "Answer.", "School.", "Grow.", "Study?", "Still,", "Learn!", "Plant,", "Cover,", "Food.", "Sun,", "Four;", "Between!", "State,", "Keep,", "Eye.", "Never,", "Last,", "Let,", "Thought?", "City,", "Tree;", "Cross,", "Farm?", "Hard,", "Start;", "Might,", "Story,", "Saw,", "Far,", "Sea!", "Draw,", "Left,", "Late,", "Run,", "Don’t!", "While!", "Press,", "Close,", "Night!", "Real!", "Life.", "Few,", "North,", "Book,", "Carry,", "Took,", "Science,", "Eat,", "Room.", "Friend!", "Began?", "Idea!", "Fish,", "Mountain,", "Stop,", "Once,", "Base,", "Hear.", "Horse?", "Cut,", "Sure:", "Watch,", "Color:", "Face,", "Wood?", "Main,", "Open,", "Seem,", "Together!", "Next,", "White,", "Children,", "Begin,", "Got!", "Walk,", "Example?", "Ease,", "Paper,", "Group,", "Always,", "Music!", "Those,", "Both,", "Mark,", "Often,", "Letter,", "Until.", "Mile?", "River!", "Car?", "Feet,", "Care,", "Second,", "Enough,", "Plain,", "Girl.", "Usual.", "Young?", "Ready,", "Above,", "Ever.", "Red?", "List:", "Though,", "Feel.", "Talk,", "Bird;", "Soon,", "Body.", "Dog,", "Family,", "Direct,", "Pose,", "Leave,", "Song.", "Measure,", "Door.", "Product;", "Black,", "Short,", "Numeral,", "Class,", "Wind;", "Question,", "Happen.", "Complete,", "Ship,", "Area,", "Half,", "Rock!", "Order!", "Fire.", "South,", "Problem;", "Piece.", "Told,", "Knew.", "Pass.", "Since,", "Top?", "Whole,", "King,", "Street,", "Inch;", "Multiply,", "Nothing.", "Course,", "Stay.", "Wheel,", "Full.", "Force,", "Blue,", "Object,", "Decide,", "Surface.", "Deep!", "Moon,", "Island,", "Foot.", "System,", "Busy,", "Test,", "Record,", "Boat,", "Common.", "Gold.", "Possible.", "Plane,", "Stead?", "Dry,", "Wonder.", "Laugh!", "Thousand.", "Ago?", "Ran,", "Check,", "Game,", "Shape;", "Equate,", "Hot,", "Miss,", "Brought,", "Heat,", "Snow!", "Tire,", "Bring,", "Yes,", "Distant?", "Fill?", "East?", "Paint!", "Language.", "Among,", "Unit.", "Power,", "Town:", "Fine,", "Certain,", "Fly,", "Fall.", "Lead!", "Cry,", "Dark.", "Machine,", "Note?", "Wait.", "Plan.", "Figure,", "Star,", "Box,", "Noun.", "Field?", "Rest,", "Correct,", "Able:", "Pound;", "Done,", "Beauty!", "Drive?", "Stood,", "Contain.", "Front.", "Teach,", "Week,", "Final;", "Gave.", "Green,", "Oh.", "Quick,", "Develop,", "Ocean,", "Warm,", "Free,", "Minute,", "Strong:", "Special,", "Mind,", "Behind,", "Clear,", "Tail.", "Produce,", "Fact;", "Space!", "Heard,", "Best,", "Hour,", "Better,", "True,", "During.", "Hundred,", "Five,", "Remember.", "Step,", "Early!", "Hold.", "West:", "Ground?", "Interest:", "Reach,", "Fast;", "Verb.", "Sing.", "Listen,", "Six,", "Table,", "Travel,", "Less.", "Morning,", "Ten,", "Simple,", "Several,", "Vowel.", "Toward,", "War!", "Lay,", "Against?", "Pattern.", "Slow?", "Center,", "Love,", "Person.", "Money.", "Serve,", "Appear.", "Road!", "Map,", "Rain,", "Rule;", "Govern.", "Pull,", "Cold,", "Notice,", "Voice,", "Energy,", "Hunt,", "Probable,", "Bed?", "Brother;", "Egg,", "Ride,", "Cell.", "Believe,", "Perhaps,", "Pick,", "Sudden,", "Count!", "Square;", "Reason.", "Length:", "Represent.", "Art?", "Subject!", "Region,", "Size,", "Vary.", "Settle.", "Speak.", "Weight.", "General,", "Ice.", "Matter,", "Circle,", "Pair,", "Include.", "Divide,", "Syllable.", "Felt,", "Grand,", "Ball.", "Yet!", "Wave,", "Drop,", "Heart,", "Am,", "Present,", "Heavy,", "Dance,", "Engine,", "Position,", "Arm,", "Wide.", "Sail,", "Material.", "Fraction,", "Forest,", "Sit?", "Race,", "Window!", "Store!", "Summer.", "Train.", "Sleep,", "Prove,", "Lone.", "Leg,", "Exercise?", "Wall,", "Catch.", "Mount?", "Wish,", "Sky.", "Board,", "Joy;", "Winter!", "Sat,", "Written,", "Wild.", "Instrument.", "Kept.", "Glass,", "Grass,", "Cow.", "Job,", "Edge.", "Sign.", "Visit,", "Past.", "Soft:", "Fun?", "Bright.", "Gas:", "Weather,", "Month,", "Million:", "Bear,", "Finish.", "Happy,", "Hope,", "Flower;", "Clothe,", "Strange,", "Gone,", "Trade.", "Melody,", "Trip!", "Office,", "Receive!", "Row.", "Mouth.", "Exact,", "Symbol,", "Die.", "Least:", "Trouble,", "Shout,", "Except.", "Wrote?", "Seed,", "Tone.", "Join:", "Suggest?", "Clean,", "Break.", "Lady,", "Yard,", "Rise,", "Bad,", "Blow.", "Oil,", "Blood,", "Touch.", "Grew,", "Cent.", "Mix,", "Team.", "Wire?", "Cost;", "Lost;", "Brown,", "Wear,", "Garden!", "Equal.", "Sent,", "Choose.", "Fell,", "Fit.", "Flow,", "Fair,", "Bank,", "Collect,", "Save.", "Control,", "Decimal.", "Ear:", "Else,", "Quite,", "Broke,", "Case,", "Middle,", "Kill;", "Son!", "Lake.", "Moment,", "Scale,", "Loud.", "Spring.", "Observe,", "Child,", "Straight,", "Consonant,", "Nation.", "Dictionary:", "Milk,", "Speed.", "Method;", "Organ,", "Pay,", "Age,", "Section.", "Dress.", "Cloud.", "Surprise!", "Quiet;", "Stone,", "Tiny.", "Climb!", "Cool,", "Design.", "Poor.", "Lot;", "Experiment.", "Bottom,", "Key,", "Iron,", "Single,", "Stick,", "Flat,", "Twenty,", "Skin.", "Smile,", "Crease!", "Hole.", "Jump,", "Baby!", "Eight,", "Village,", "Meet,", "Root.", "Buy,", "Raise,", "Solve;", "Metal?", "Whether?", "Push!", "Seven,", "Paragraph.", "Third,", "Shall,", "Held;", "Hair,", "Describe,", "Cook,", "Floor,", "Either,", "Result,", "Burn!", "Hill,", "Safe,", "Cat,", "Century,", "Consider,", "Type,", "Law.", "Bit,", "Coast,", "Copy.", "Phrase,", "Silent,", "Tall?", "Sand,", "Soil,", "Roll.", "Temperature,", "Finger!", "Industry.", "Value,", "Fight,", "Lie,", "Beat,", "Excite,", "Natural:", "View,", "Sense,", "Capital,", "Won’t,", "Chair.", "Danger,", "Fruit,", "Rich.", "Thick,", "Soldier:", "Process?", "Operate?", "Practice,", "Separate,", "Difficult.", "Doctor,", "Please.", "Protect,", "Noon,", "Crop,", "Modern.", "Element,", "Hit,", "Student.", "Corner,", "Party,", "Supply,", "Whose.", "Locate,", "Ring,", "Character,", "Insect,", "Caught,", "Period!", "Indicate,", "Radio,", "Spoke,", "Atom,", "Human,", "History.", "Effect.", "Electric.", "Expect!", "Bone.", "Rail,", "Imagine.", "Provide,", "Agree:", "Thus,", "Gentle?", "Woman,", "Captain,", "Guess,", "Necessary.", "Sharp,", "Wing:", "Create,", "Neighbor,", "Wash,", "Bat.", "Rather,", "Crowd,", "Corn?", "Compare,", "Poem,", "String,", "Bell!", "Depend,", "Meat.", "Rub,", "Tube,", "Famous:", "Dollar,", "Stream,", "Fear,", "Sight.", "Thin,", "Triangle,", "Planet,", "Hurry.", "Chief?", "Colony.", "Clock.", "Mine,", "Tie.", "Enter,", "Major,", "Fresh,", "Search;", "Send,", "Yellow,", "Gun.", "Allow.", "Print,", "Dead:", "Spot,", "Desert.", "Suit.", "Current.", "Lift,", "Rose,", "Arrive,", "Master!", "Track,", "Parent,", "Shore.", "Division,", "Sheet,", "Substance,", "Favor.", "Connect,", "Post.", "Spend;", "Chord,", "Fat,", "Glad,", "Original.", "Share,", "Station!", "Dad,", "Bread.", "Charge.", "Proper.", "Bar,", "Offer,", "Segment:", "Slave,", "Duck?", "Instant,", "Market.", "Degree.", "Populate,", "Chick!", "Dear,", "Enemy,", "Reply.", "Drink,", "Occur.", "Support.", "Speech?", "Nature.", "Range?", "Steam,", "Motion.", "Path,", "Liquid.", "Log.", "Meant,", "Quotient?", "Teeth,", "Shell,", "Neck,", "Oxygen.", "Sugar,", "Death,", "Pretty.", "Skill.", "Women,", "Season,", "Solution,", "Magnet!", "Silver.", "Thank,", "Branch,", "Match,", "Suffix,", "Especially.", "Fig,", "Afraid,", "Huge.", "Sister,", "Steel,", "Discuss,", "Forward.", "Similar.", "Guide.", "Experience:", "Score,", "Apple:", "Bought,", "Led.", "Pitch,", "Coat.", "Mass,", "Card,", "Band?", "Rope,", "Slip,", "Win,", "Dream,", "Evening:", "Condition,", "Feed,", "Tool:", "Total.", "Basic!", "Smell,", "Valley?", "Nor,", "Double:", "Seat,", "Continue!", "Block,", "Chart?", "Hat.", "Sell,", "Success?", "Company.", "Subtract,", "Event.", "Particular?", "Deal,", "Swim,", "Term,", "Opposite.", "Wife?", "Shoe,", "Shoulder.", "Spread?", "Arrange,", "Camp,", "Invent;", "Cotton;", "Born?", "Determine,", "Quart,", "Nine,", "Truck.", "Noise,", "Level,", "Chance,", "Gather,", "Shop,", "Stretch,", "Throw:", "Shine?", "Property,", "Column,", "Molecule!", "Select,", "Wrong,", "Gray,", "Repeat,", "Require,", "Broad,", "Prepare,", "Salt,", "Nose?", "Plural!", "Anger.", "Claim.", "Continent."};
        //The array that will be formatted and used for highlighting and many others
        String[] Text = new String[20];
        //Default will be Easy - you can change later after running
        while (repeatOuter) {
            System.out.println("Choose Your Difficulty: 1-Easy, 2-Medium ,3-Hard");
            while (!chosenCorrectly) {
                System.out.print("Input:");
            
                String chosenDifficulty = s.nextLine();
                if (chosenDifficulty.trim().equals("1") || chosenDifficulty.trim().equalsIgnoreCase("Easy")) {
                    System.out.println(textFormatter(Easy, Text));
                    chosenCorrectly = true;
                }
                else if (chosenDifficulty.trim().equals("2") || chosenDifficulty.trim().equalsIgnoreCase("Medium")) {
                    System.out.println(textFormatter(Medium, Text));
                    chosenCorrectly = true;
                }
                else if (chosenDifficulty.trim().equals("3") || chosenDifficulty.trim().equalsIgnoreCase("Hard")) {
                    System.out.println(textFormatter(Hard, Text));
                    chosenCorrectly = true;
                }
                else {
                    System.out.println("Please Choose A Correct Difficulty!");
                }
            }
            System.out.print("3  ");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("2  ");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("1  ");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Go!!");
            long startTime = LocalTime.now().toNanoOfDay();
        
            String input = s.nextLine();
        
            long endTime = LocalTime.now().toNanoOfDay();
        
            double timeSpent = ((endTime - startTime) / 6e+10);
        
            String[] words = input.split(" ");
            //Calculating number of correct characters typed for accuracy
            double correctLength = 0;
            for (int i = 0; i < words.length; i++) {
            /*
            If you type the word correctly but add anything after
            only the other character will be counted wrong not the whole word
            example: welcomer, correct: welcome, wrong: r, number of wrong characters: 1
            */
                if (words[i].length() > Text[i].length()) {
                    correctLength -= words[i].length() - Text[i].length() - 1;
                }
                for (int j = 0; j < Text[i].length(); j++) {
                    //try this
                    try {
                        char yourChar = words[i].charAt(j);
                        char correctChar = Text[i].charAt(j);
                        if (yourChar == correctChar) {
                            correctLength++;
                        }
                    }
                            /*
                            If word is uncompleted calculate number of characters left
                            and subtract it from number of correct characters
                            so, if you left a word uncompleted and time runs out
                            it will be considered wrong
                            */
                    catch (StringIndexOutOfBoundsException e) {
                        if (correctLength > words[i].length()) {
                            correctLength -= Text[i].length() - words[i].length();
                        }
                        break;
                    }
                }
            }
            //Calculating for WPM and WPM - Error
            String wPM = "0";
            if (words.length > 1) {
                wPM = String.valueOf(Math.round(words.length / timeSpent));//Words Per Minute
            }
            //Accuracy based on individual characters
            double rawAccuracy = correctLength / input.replaceAll(" ", "").length();
            String accuracy = formatter.format((rawAccuracy * 100));
            //WPM - ERROR (raw wpm * accuracy)
            String wPM_Error = String.valueOf(Math.round(Double.parseDouble(wPM) * (rawAccuracy)));
        /*
                    setting up the label that to show the results, such as speed and accuracy
                    Css is used to lessen the code complexity and time
                    other methods require three labels since JLabel doesn't support multiline
                    */
            System.out.println("Your speed was: " + wPM_Error + " WPM" + "\nACCURACY: " + accuracy + " | " + " CORRECT CHARS: " + (int) correctLength + "/" + input.replaceAll(" ", "").length() + "\nRAW WPM: " + wPM);
        /*
                    Creating(if not already) and writing the results you get each time to a file on the desktop
                    It automatically finds the desktop(works only on Windows)
                    If you're on Mac or Linux you have to specify the path
                    */
            File results = new File(System.getProperty("user.home") + "/Desktop" + "\\results.txt");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            try {
                FileWriter resultWriter = new FileWriter(results, true);
                resultWriter.write(wPM_Error + "WPM-ACR : Accuracy: " + accuracy + " : " + (timeSpent * 60) + "S Test" + " : Username: " + Main.username + " : Difficulty: " + difficulty + " : Date: " + dateFormat.format(LocalDateTime.now()) + "\n");
                resultWriter.close();
            }
            catch (IOException e) {
                System.out.println("Failed To Write To File!");
            }
            System.out.println("Do You Want To 1-Repeat Or 2-Exit");
            String repeatOuterQ = s.nextLine();
            if (repeatOuterQ.trim().equalsIgnoreCase("repeat") || repeatOuterQ.trim().equals("1")) {
                chosenCorrectly = false;
                repeatOuter = true;
                continue;
            }
            if (repeatOuterQ.trim().equalsIgnoreCase("exit") || repeatOuterQ.trim().equals("2")) {
                repeatOuter = false;
            }
            else {
                System.out.println("Please choose a correct option!");
            }
        }
    }
    
    //Methods
    static String textFormatter(String[] TextSample, String[] Text) {
        //Emptying the array first
        Arrays.fill(Text, "");
        //Formatting the array into a string with a space " " between each index
        for (int m = 0; m < Text.length; m++) {
            Text[m] = TextSample[(int) (Math.random() * TextSample.length)];
        }
        StringJoiner joiner = new StringJoiner(" ");
        for (String value : Text) {
            joiner.add(value);
        }
        return joiner.toString();
    }
}
