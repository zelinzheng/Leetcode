public class SimplifyPath  {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";
        
        String elements[] = path.split("/");
        Stack<String> store = new Stack<String>();
        for(int i=0; i<elements.length; i++) {
            if(!elements[i].equals("")&&!elements[i].equals(".")) {
                if(elements[i].equals("..")) {
                    if(!store.isEmpty())store.pop();
                }
                else 
                    store.push(elements[i]);
            }
        }
        String ret = "";
        while(!store.isEmpty()) {
            ret = "/" + store.pop() + ret;
        }
        
        return ret==""?"/":ret;
    }
}