public class Start extends UserInterface{
    private final UserInterface userInterface = new UserInterface();
    private final WorkWithFile workWithFile = new WorkWithFile();
    public void runProgram(){
        int count = 0;
        String[] result = userInterface.userData();
        for (String string: result){
            if (string == null){
                count++;
            }
        }
        if (count == 0){
            workWithFile.workWithFile(result[0].replace(",", "") + ".txt", result);
        }
        else {
            System.out.println("Файл не был создан");
        }
    }
}
