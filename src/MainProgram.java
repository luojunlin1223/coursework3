import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainProgram {
    private static SortedArrayList<Event> events=new SortedArrayList<>();
    private static SortedArrayList<Client> clients=new SortedArrayList<>();

    public static void load_file() throws IOException {

        List<String> content=new ArrayList<>();
        File file =new File("input.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,"GBK");
        BufferedReader reader=new BufferedReader(inputStreamReader);
        String lineContent="";
        while ((lineContent=reader.readLine())!=null){
            content.add(lineContent);
        }
        fileInputStream.close();
        inputStreamReader.close();
        reader.close();

        int current_position=1;
        for (int i = 0; i <Integer.parseInt(content.get(0)); i++) {
            events.add(new Event(content.get(current_position),Integer.parseInt(content.get(current_position+1))));
            current_position+=2;
        }

        int record=current_position;
        for (int i = 0; i < Integer.parseInt(content.get(record)); i++) {
            current_position+=1;
            clients.add(new Client(content.get(current_position)));
        }

    }
    public static void main(String[] args) throws IOException {
        load_file();//加载文件信息到 events 和 clients 里面
        while (true){
            Scanner scanner=new Scanner(System.in);
            String input=scanner.next();
            switch (input){
                case "f"->
                    System.exit(0);
                case "e"->{
                    for (Event e: events
                         ) {
                        System.out.print(e+" "+e.getTicket());
                        System.out.print("\n");
                    }
                }
                case "c"->{
                    for (Client c: clients
                    ) {
                        String content="";
                        if(c.getPair().size()==0)
                            content="Noting to buy";
                        else
                            content=c.getPair().toString();
                        System.out.print(c.getFirst_name()+" "+c.getSurname()+" "+content);
                        System.out.print("\n");
                    }
                }
                case "b"->{
                    for (Event e: events
                    ) {
                        System.out.print(e+" "+e.getTicket());
                        System.out.print("\n");
                    }
                    String event_string;
                    Integer number;
                    System.out.print("Which event do you want to buy?");
                    event_string=scanner.next();
                    System.out.print("How many ticket do you want to buy?");
                    number=scanner.nextInt();


                    Map<Event,Integer> pair= clients.get(0).getPair();

                    for (Event event:events
                         ) {
                        if(event_string.equals(event.getName()))
                        {
                            try{

                                pair.put(event,pair.get(event)+number);
                            }catch (NullPointerException e){

                                pair.put(event,+number);
                            }

                            clients.get(0).setPair(pair);
                        }
                    }



                }
                case "r"->{

                }
                default -> {}//以上条件都不成立的时候 运行这个
            }

        }
    }
}
