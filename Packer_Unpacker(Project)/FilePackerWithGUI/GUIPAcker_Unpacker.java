import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

// ─────────────────────────────────────────────
//  Core Logic  (your original code from Main.java — not changed)
// ─────────────────────────────────────────────
class FilePackerUnpacker
{
    private final byte Key;
    
    {
      this.Key=0x11;
    }

    public boolean filePacker(String DirName,String FileName) 
    {
      
     boolean bRet=false;
     String header=null;
     int i=0,iRet=0,j=0;
    byte Buffer[] = new byte[1024];
    byte bheader[] = new byte[100];
    File PackObj =null;
     FileOutputStream foobj =null;
    FileInputStream fiobj = null;
    File fobj=null;
try{
      
    PackObj= new File(FileName);
     PackObj.createNewFile();
     
     foobj  = new FileOutputStream(PackObj);
     
     fobj = new File(DirName);
     
     if((fobj.exists())&& (fobj.isDirectory()))
        {
          bRet=true;
            System.out.println("Folder is Present");
            
            File fArr [] = fobj.listFiles();
            
            System.out.println("No of Files:"+fArr.length);

             for(i=0;i<fArr.length;i++)
             {
                fiobj = new FileInputStream(fArr[i]);
                
                if(fArr[i].getName().endsWith(".txt"))
                 {
                    //Header Formation
                    header=fArr[i].getName() + " " + fArr[i].length();

                        for(j=header.length();j<100;j++)
                        {
                            header=header+" ";
                        }
                         bheader=header.getBytes();

                         //Write Header into Packed File
                         foobj.write(bheader,0,100);

                   //read data from input files from MyFiles folder      
                   while ((iRet=fiobj.read(Buffer))!=-1)
                   {
                     //Encryption Logic
                     for(j=0;j<iRet;j++)
                     {
                        Buffer[j]=(byte)(Buffer[j]^this.Key);
                     }

                     //write files data into Packed file
                      foobj.write(Buffer,0,iRet);
                   }
                 
                 }
                fiobj.close();
             }
             System.out.println("Files From "+DirName+" Directory Packed into "+FileName+" Sucessfully.");
             
             foobj.close();
             
            }  
        else
        {
           foobj.close();
           return bRet;
        }       
        }
        catch(Exception E)
        {
          System.out.println("Error Occured:"+E);
        }
        return bRet;
        
    }

  public boolean fileUnpacker(String PackFile)
  {
     //variable creation
      int FileSize=0;
    int i=0,iRet=0;
     boolean bRet=false;
      String tokens[]=null;
      String Header=null;
      File fpackobj = null;
      File fobj = null;
      FileInputStream fiobj =null;
      FileOutputStream foobj = null;
      byte Bheader[] = new byte[100];
      byte Buffer[]  = null;
       

     
try{
       fpackobj = new File(PackFile);
        if(fpackobj.exists()==false)
       {
        return bRet;
      }
             bRet =true;
            fiobj = new FileInputStream(fpackobj);

         //Reading header
        while((iRet = fiobj.read(Bheader,0,100)) !=-1)
        {
               Header = new String(Bheader);//Byte to String Conversion(explicit)

               Header = Header.trim();

               tokens = Header.split(" ");

              System.out.println("File Name:"+tokens[0]);
               System.out.println("File Size:"+tokens[1]);

                fobj = new File(tokens[0]);
                fobj.createNewFile();
                foobj = new FileOutputStream(fobj);

              FileSize = Integer.parseInt(tokens[1]);

               //buffer for reading filesize
            Buffer = new byte[FileSize];
    
              //read from packed file
               fiobj.read(Buffer,0,FileSize);

              //Decrypting data
               for(i=0;i<FileSize;i++)
               {
                   Buffer[i]=(byte)(Buffer[i]^this.Key);
               }

               //write into extracted file
                foobj.write(Buffer,0,FileSize);
   
        }
  
               System.out.println("Data From "+PackFile+" Unpacked Sucessfully." );
               
    }
    catch(Exception E)
    {
       System.out.println("Error Occured:"+E);
    }    
    return bRet;
  }
}


// ─────────────────────────────────────────────
//  GUI
// ─────────────────────────────────────────────
public class GUIPAcker_Unpacker extends JFrame {

    // ── Palette ──────────────────────────────
    private static final Color C_BG      = new Color(240, 242, 245);
    private static final Color C_HEADER  = new Color(37,  99, 235);
    private static final Color C_PACK    = new Color(37,  99, 235);
    private static final Color C_UNPACK  = new Color(22, 163,  74);
    private static final Color C_CONSOLE = new Color(22,  27,  34);
    private static final Color C_TEXT_OK = new Color(134, 239, 172);
    private static final Color C_TEXT_ER = new Color(252, 165, 165);

    // ── Pack tab ─────────────────────────────
    private JTextField  tfDir, tfPackOut;
    private JTextArea   taPackLog;
    private JButton     btnPack;

    // ── Unpack tab ───────────────────────────
    private JTextField  tfPackedFile;
    private JTextArea   taUnpackLog;
    private JButton     btnUnpack;

    private final FilePackerUnpacker engine = new FilePackerUnpacker();

    // ─────────────────────────────────────────
    public GUIPAcker_Unpacker() {
        super("File Packer-Unpacker");
        buildFrame();
    }

    // ── Frame shell ──────────────────────────
    private void buildFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(660, 520);
        setMinimumSize(new Dimension(580, 480));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0, 0));

        add(buildHeader(),  BorderLayout.NORTH);
        add(buildTabs(),    BorderLayout.CENTER);
        add(buildFooter(),  BorderLayout.SOUTH);
    }

    // ── Top blue header bar ───────────────────
    private JPanel buildHeader() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 18, 0));
        p.setBackground(C_HEADER);
        p.setPreferredSize(new Dimension(660, 52));

        JLabel icon  = new JLabel("📦");
        icon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 22));

        JLabel title = new JLabel("File Packer-Unpacker");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.WHITE);

        JLabel sub = new JLabel("XOR Encrypted · Java");
        sub.setFont(new Font("Arial", Font.PLAIN, 11));
        sub.setForeground(new Color(186, 214, 255));

        JPanel text = new JPanel(new GridLayout(2, 1, 0, 0));
        text.setOpaque(false);
        text.add(title);
        text.add(sub);

        p.add(icon);
        p.add(text);
        return p;
    }

    // ── Tabbed content area ───────────────────
    private JTabbedPane buildTabs() {
        JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
        tabs.setFont(new Font("Arial", Font.BOLD, 13));
        tabs.setBackground(C_BG);
        tabs.addTab("  Pack  ",   buildPackPanel());
        tabs.addTab("  Unpack  ", buildUnpackPanel());
        return tabs;
    }

    // ── Pack tab ─────────────────────────────
    private JPanel buildPackPanel() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBackground(C_BG);
        root.setBorder(new EmptyBorder(20, 20, 10, 20));

        // ── Form (top) ──
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(C_BG);
        GridBagConstraints gc = defaultGBC();

        // Row 0 : Source Directory
        gc.gridx = 0; gc.gridy = 0; gc.weightx = 0;
        form.add(label("Source Directory :"), gc);

        tfDir = textField();
        gc.gridx = 1; gc.weightx = 1.0;
        form.add(tfDir, gc);

        gc.gridx = 2; gc.weightx = 0;
        form.add(browseBtn("Browse", true, tfDir), gc);

        // Row 1 : Output File
        gc.gridx = 0; gc.gridy = 1; gc.weightx = 0;
        form.add(label("Output File Name :"), gc);

        tfPackOut = textField();
        gc.gridx = 1; gc.weightx = 1.0;
        form.add(tfPackOut, gc);

        gc.gridx = 2; gc.weightx = 0;
        form.add(saveBtn("Browse", tfPackOut), gc);

        // Row 2 : Pack button
        btnPack = actionBtn("  Pack Files  ", C_PACK, e -> doPack());
        gc.gridx = 0; gc.gridy = 2; gc.gridwidth = 3;
        gc.fill  = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(14, 0, 4, 0);
        form.add(btnPack, gc);

        // ── Console (bottom) ──
        taPackLog = console();
        JScrollPane sp = scrollWrap(taPackLog);

        root.add(form, BorderLayout.NORTH);
        root.add(consolePanel(sp), BorderLayout.CENTER);
        return root;
    }

    // ── Unpack tab ───────────────────────────
    private JPanel buildUnpackPanel() {
        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBackground(C_BG);
        root.setBorder(new EmptyBorder(20, 20, 10, 20));

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(C_BG);
        GridBagConstraints gc = defaultGBC();

        // Row 0 : Packed file
        gc.gridx = 0; gc.gridy = 0; gc.weightx = 0;
        form.add(label("Packed File :"), gc);

        tfPackedFile = textField();
        gc.gridx = 1; gc.weightx = 1.0;
        form.add(tfPackedFile, gc);

        gc.gridx = 2; gc.weightx = 0;
        form.add(browseBtn("Browse", false, tfPackedFile), gc);

        // Row 1 : Unpack button
        btnUnpack = actionBtn("  Unpack Files  ", C_UNPACK, e -> doUnpack());
        gc.gridx = 0; gc.gridy = 1; gc.gridwidth = 3;
        gc.fill  = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(14, 0, 4, 0);
        form.add(btnUnpack, gc);

        taUnpackLog = console();
        JScrollPane sp = scrollWrap(taUnpackLog);

        root.add(form, BorderLayout.NORTH);
        root.add(consolePanel(sp), BorderLayout.CENTER);
        return root;
    }

    // ── Status bar ───────────────────────────
    private JPanel buildFooter() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 4));
        p.setBackground(new Color(225, 228, 232));
        p.setBorder(new MatteBorder(1, 0, 0, 0, new Color(200, 202, 205)));
        JLabel lbl = new JLabel("Only .txt files are packed  ·  XOR key : 0x11  ·  CLI version : Main.java");
        lbl.setFont(new Font("Arial", Font.PLAIN, 11));
        lbl.setForeground(new Color(100, 108, 120));
        p.add(lbl);
        return p;
    }

    // ─────────────────────────────────────────
    //  Actions
    // ─────────────────────────────────────────
    private void doPack() {
        String dir = tfDir.getText().trim();
        String out = tfPackOut.getText().trim();

        if (dir.isEmpty() || out.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please fill in both fields before packing.",
                "Missing Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        taPackLog.setText("");
        taPackLog.setForeground(C_TEXT_OK);
        setPackBusy(true);

        new SwingWorker<Boolean, String>() {
            @Override protected Boolean doInBackground() {
                publish("Starting pack operation...\n");
                publish("Directory  :  " + dir + "\n");
                publish("Output     :  " + out + "\n");
                publish("─────────────────────────────────\n");
                return captureAndRun(() -> engine.filePacker(dir, out));
            }
            @Override protected void process(java.util.List<String> chunks) {
                chunks.forEach(taPackLog::append);
            }
            @Override protected void done() {
                finishWorker(this, taPackLog, btnPack, "  Pack Files  ");
            }
        }.execute();
    }

    private void doUnpack() {
        String pf = tfPackedFile.getText().trim();

        if (pf.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please select a packed file first.",
                "Missing Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        taUnpackLog.setText("");
        taUnpackLog.setForeground(C_TEXT_OK);
        setUnpackBusy(true);

        new SwingWorker<Boolean, String>() {
            @Override protected Boolean doInBackground() {
                publish("Starting unpack operation...\n");
                publish("Packed file :  " + pf + "\n");
                publish("─────────────────────────────────\n");
                return captureAndRun(() -> engine.fileUnpacker(pf));
            }
            @Override protected void process(java.util.List<String> chunks) {
                chunks.forEach(taUnpackLog::append);
            }
            @Override protected void done() {
                finishWorker(this, taUnpackLog, btnUnpack, "  Unpack Files  ");
            }
        }.execute();
    }

    // ─────────────────────────────────────────
    //  Helpers
    // ─────────────────────────────────────────

    /** Redirects System.out during fn(), returns fn()'s result. */
    private Boolean captureAndRun(java.util.function.Supplier<Boolean> fn) {
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream capture  = new PrintStream(baos) {
            @Override public void println(String s) {
                super.println(s);
                // nothing extra — we read the buffer after
            }
        };
        System.setOut(capture);
        Boolean result = fn.get();
        capture.flush();
        System.setOut(original);
        // The captured text will be appended via publish in the caller's done()
        // We publish it here through a side-channel via a shared string.
        capturedOutput = baos.toString();
        return result;
    }

    // Tiny side-channel between captureAndRun and finishWorker
    // (SwingWorker generics make publishing from a helper awkward — this is simpler)
    private volatile String capturedOutput = "";

    private void finishWorker(SwingWorker<Boolean, ?> w,
                              JTextArea log,
                              JButton btn,
                              String btnLabel) {
        log.append(capturedOutput);
        capturedOutput = "";
        try {
            boolean ok = (Boolean) w.get();
            if (ok) {
                log.append("\n✅  Operation completed successfully.\n");
                log.setForeground(C_TEXT_OK);
            } else {
                log.append("\n❌  Operation failed. Check the path and try again.\n");
                log.setForeground(C_TEXT_ER);
            }
        } catch (Exception ex) {
            log.append("\n❌  Unexpected error: " + ex.getMessage() + "\n");
            log.setForeground(C_TEXT_ER);
        }
        btn.setEnabled(true);
        btn.setText(btnLabel);
    }

    private void setPackBusy(boolean busy) {
        btnPack.setEnabled(!busy);
        btnPack.setText(busy ? "Packing…" : "  Pack Files  ");
    }

    private void setUnpackBusy(boolean busy) {
        btnUnpack.setEnabled(!busy);
        btnUnpack.setText(busy ? "Unpacking…" : "  Unpack Files  ");
    }

    // ── Widget factories ─────────────────────

    private static JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("Arial", Font.PLAIN, 13));
        return l;
    }

    private static JTextField textField() {
        JTextField tf = new JTextField();
        tf.setFont(new Font("Arial", Font.PLAIN, 13));
        tf.setPreferredSize(new Dimension(300, 28));
        return tf;
    }

    private JButton browseBtn(String label, boolean dirOnly, JTextField target) {
        JButton b = smallBtn(label);
        b.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(dirOnly
                    ? JFileChooser.DIRECTORIES_ONLY
                    : JFileChooser.FILES_ONLY);
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
                target.setText(fc.getSelectedFile().getAbsolutePath());
        });
        return b;
    }

    private JButton saveBtn(String label, JTextField target) {
        JButton b = smallBtn(label);
        b.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Save packed file as…");
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
                target.setText(fc.getSelectedFile().getAbsolutePath());
        });
        return b;
    }

    private static JButton smallBtn(String label) {
        JButton b = new JButton(label);
        b.setFont(new Font("Arial", Font.PLAIN, 12));
        b.setPreferredSize(new Dimension(85, 28));
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    private static JButton actionBtn(String text, Color bg, ActionListener al) {
        JButton b = new JButton(text);
        b.setFont(new Font("Arial", Font.BOLD, 13));
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setOpaque(true);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setPreferredSize(new Dimension(160, 36));
        b.addActionListener(al);
        return b;
    }

    private static JTextArea console() {
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        ta.setFont(new Font("Monospaced", Font.PLAIN, 12));
        ta.setBackground(C_CONSOLE);
        ta.setForeground(C_TEXT_OK);
        ta.setCaretColor(Color.WHITE);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setMargin(new Insets(8, 10, 8, 10));
        return ta;
    }

    private static JScrollPane scrollWrap(JTextArea ta) {
        JScrollPane sp = new JScrollPane(ta);
        sp.setBorder(BorderFactory.createLineBorder(new Color(60, 65, 72)));
        return sp;
    }

    private static JPanel consolePanel(JScrollPane sp) {
        JPanel p = new JPanel(new BorderLayout(0, 4));
        p.setBackground(C_BG);
        JLabel lbl = new JLabel("Output");
        lbl.setFont(new Font("Arial", Font.BOLD, 12));
        lbl.setForeground(new Color(80, 90, 110));
        p.add(lbl, BorderLayout.NORTH);
        p.add(sp,  BorderLayout.CENTER);
        return p;
    }

    private static GridBagConstraints defaultGBC() {
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets  = new Insets(6, 6, 6, 6);
        gc.fill    = GridBagConstraints.HORIZONTAL;
        gc.anchor  = GridBagConstraints.WEST;
        gc.gridwidth = 1;
        return gc;
    }

    // ─────────────────────────────────────────
    //  Entry point
    // ─────────────────────────────────────────
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new GUIPAcker_Unpacker().setVisible(true));
    }
}