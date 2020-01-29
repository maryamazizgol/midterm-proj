import model.entity.PersonEnti;
import model.repository.PersonRepo;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersonInfo extends   Ordering implements ActionListener {

    ArrayList personsList;
    PersonRepo prep;
    JFrame mFrame;
    JLabel jlbName, jlbAddress, jlbPhone, jlbEmail;
    JTextField jtfName, jtfAddress, jtfPhone, jtfEmail;
    JButton jbbSave, jbnDelete, jbnClear, jbnUpdate, jbnSearch, jbnForward, jbnBack, jbnExit;
    String name, address, email;
    int phone;
    int recordNumber;
    Container cPane;


    public PersonInfo() {
        name = "";
        address = "";
        email = "";
        phone = -1;
        recordNumber = -1;

        show();

        personsList = new ArrayList();


        prep = new PersonRepo();

    }

    public void show() {

        mFrame = new JFrame("دفترچه آدرس");

        cPane = mFrame.getContentPane();
        cPane.setLayout(new GridBagLayout());

        ordering1();

        mFrame.setSize(600, 600);
        mFrame.setResizable(false);
        mFrame.setVisible(true);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

  @Override
    public void ordering1() {
        jlbName = new JLabel("اسم");
        jlbAddress = new JLabel("آدرس");
        jlbPhone = new JLabel("شماره تلفن");
        jlbEmail = new JLabel("ایمیل");

        jtfName = new JTextField(20);
        jtfAddress = new JTextField(20);
        jtfPhone = new JTextField(20);
        jtfEmail = new JTextField(20);

        jbbSave = new JButton("ذخیره");
        jbnDelete = new JButton("حذف");
        jbnClear = new JButton("پاک کردن");
        jbnUpdate = new JButton("به روز رسانی");
        jbnSearch = new JButton("جست وجو");

        jbnForward = new JButton("==>");
        jbnBack = new JButton("<==");
        jbnExit = new JButton("خروج");


        GridBagConstraints gridBagConstraintsx01 = new GridBagConstraints();
        gridBagConstraintsx01.gridx = 0;
        gridBagConstraintsx01.gridy = 0;
        gridBagConstraintsx01.insets = new Insets(5, 5, 5, 5);
        cPane.add(jlbName, gridBagConstraintsx01);

        GridBagConstraints gridBagConstraintsx02 = new GridBagConstraints();
        gridBagConstraintsx02.gridx = 1;
        gridBagConstraintsx02.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx02.gridy = 0;
        gridBagConstraintsx02.gridwidth = 2;
        gridBagConstraintsx02.fill = GridBagConstraints.BOTH;
        cPane.add(jtfName, gridBagConstraintsx02);

        GridBagConstraints gridBagConstraintsx03 = new GridBagConstraints();
        gridBagConstraintsx03.gridx = 0;
        gridBagConstraintsx03.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx03.gridy = 1;
        cPane.add(jlbAddress, gridBagConstraintsx03);

        GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
        gridBagConstraintsx04.gridx = 1;
        gridBagConstraintsx04.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx04.gridy = 1;
        gridBagConstraintsx04.gridwidth = 2;
        gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
        cPane.add(jtfAddress, gridBagConstraintsx04);

        GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
        gridBagConstraintsx05.gridx = 0;
        gridBagConstraintsx05.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx05.gridy = 2;
        cPane.add(jlbPhone, gridBagConstraintsx05);

        GridBagConstraints gridBagConstraintsx06 = new GridBagConstraints();
        gridBagConstraintsx06.gridx = 1;
        gridBagConstraintsx06.gridy = 2;
        gridBagConstraintsx06.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx06.gridwidth = 2;
        gridBagConstraintsx06.fill = GridBagConstraints.BOTH;
        cPane.add(jtfPhone, gridBagConstraintsx06);

        GridBagConstraints gridBagConstraintsx07 = new GridBagConstraints();
        gridBagConstraintsx07.gridx = 0;
        gridBagConstraintsx07.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx07.gridy = 3;
        cPane.add(jlbEmail, gridBagConstraintsx07);

        GridBagConstraints gridBagConstraintsx08 = new GridBagConstraints();
        gridBagConstraintsx08.gridx = 1;
        gridBagConstraintsx08.gridy = 3;
        gridBagConstraintsx08.gridwidth = 2;
        gridBagConstraintsx08.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx08.fill = GridBagConstraints.BOTH;
        cPane.add(jtfEmail, gridBagConstraintsx08);

        GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
        gridBagConstraintsx09.gridx = 0;
        gridBagConstraintsx09.gridy = 4;
        gridBagConstraintsx09.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbbSave, gridBagConstraintsx09);

        GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
        gridBagConstraintsx10.gridx = 1;
        gridBagConstraintsx10.gridy = 4;
        gridBagConstraintsx10.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnDelete, gridBagConstraintsx10);

        GridBagConstraints gridBagConstraintsx11 = new GridBagConstraints();
        gridBagConstraintsx11.gridx = 2;
        gridBagConstraintsx11.gridy = 4;
        gridBagConstraintsx11.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnUpdate, gridBagConstraintsx11);

        GridBagConstraints gridBagConstraintsx12 = new GridBagConstraints();
        gridBagConstraintsx12.gridx = 0;
        gridBagConstraintsx12.gridy = 5;
        gridBagConstraintsx12.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnBack, gridBagConstraintsx12);

        GridBagConstraints gridBagConstraintsx13 = new GridBagConstraints();
        gridBagConstraintsx13.gridx = 1;
        gridBagConstraintsx13.gridy = 5;
        gridBagConstraintsx13.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnSearch, gridBagConstraintsx13);

        GridBagConstraints gridBagConstraintsx14 = new GridBagConstraints();
        gridBagConstraintsx14.gridx = 2;
        gridBagConstraintsx14.gridy = 5;
        gridBagConstraintsx14.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnForward, gridBagConstraintsx14);

        GridBagConstraints gridBagConstraintsx15 = new GridBagConstraints();
        gridBagConstraintsx15.gridx = 1;
        gridBagConstraintsx15.insets = new Insets(5, 5, 5, 5);
        gridBagConstraintsx15.gridy = 6;
        cPane.add(jbnClear, gridBagConstraintsx15);

        GridBagConstraints gridBagConstraintsx16 = new GridBagConstraints();
        gridBagConstraintsx16.gridx = 2;
        gridBagConstraintsx16.gridy = 6;
        gridBagConstraintsx16.insets = new Insets(5, 5, 5, 5);
        cPane.add(jbnExit, gridBagConstraintsx16);

        jbbSave.addActionListener(this);
        jbnDelete.addActionListener(this);
        jbnClear.addActionListener(this);
        jbnUpdate.addActionListener(this);
        jbnSearch.addActionListener(this);
        jbnForward.addActionListener(this);
        jbnBack.addActionListener(this);
        jbnExit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jbbSave) {
            savePerson();
            clear();
        } else if (e.getSource() == jbnDelete) {
            deletePerson();
            clear();
        } else if (e.getSource() == jbnUpdate) {
            updatePerson();
            clear();
        } else if (e.getSource() == jbnSearch) {
            searchPerson();
        } else if (e.getSource() == jbnForward) {
            displayNextRecord();
        } else if (e.getSource() == jbnBack) {
            displayPreviousRecord();
        } else if (e.getSource() == jbnClear) {
            clear();
        } else if (e.getSource() == jbnExit) {
            System.exit(0);
        }

    }


    public void savePerson() {
        name = jtfName.getText();
        name = name.toUpperCase();
        address = jtfAddress.getText();
        try {
            phone = Integer.parseInt("" + jtfPhone.getText());
        } catch (Exception e) {
            System.out.print("استرینگ وارد کنید");
            JOptionPane.showMessageDialog(null, "شماره تلفن را وارد کنید");

        }

        email = jtfEmail.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "نام را وارد کنید");
        } else {

            PersonEnti person = new PersonEnti(name, address, phone, email);
            prep.save(person);
            JOptionPane.showMessageDialog(null, "ذخیره شد");
        }
    }

    public void deletePerson() {

        name = jtfName.getText();
        name = name.toUpperCase();
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "نام فرد را برای حذف وارد کنید");
        } else {

            int numberOfDeleted = prep.remove(name);
            JOptionPane.showMessageDialog(null, numberOfDeleted + " Record(s) deleted.");
        }
    }

    public void updatePerson() {
        if (recordNumber >= 0 && recordNumber < personsList.size()) {
            PersonEnti person = (PersonEnti) personsList.get(recordNumber);

            int id = person.getId();
            name = jtfName.getText();
            address = jtfAddress.getText();
            phone = Integer.parseInt(jtfPhone.getText());
            email = jtfEmail.getText();

            person = new PersonEnti(id, name, address, phone, email);
            prep.update(person);

            JOptionPane.showMessageDialog(null, "مشخصات فرد با موفقیت به روزرسانی شد");
        } else {
            JOptionPane.showMessageDialog(null, "اطلاعاتی برای به روزرسانی وجود ندارد");
        }
    }



    public void searchPerson() {

        name = jtfName.getText();
        name = name.toUpperCase();

        personsList.clear();

        recordNumber = 0;

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "نام فرد را برای جست وجو وارد کنید");
        } else {

            personsList = prep.search(name);

            if (personsList.size() == 0) {
                JOptionPane.showMessageDialog(null, "اطلاعاتی پیدا نشد");

                clear();
            } else {

                PersonEnti person = (PersonEnti) personsList.get(recordNumber);


                jtfName.setText(person.getName());
                jtfAddress.setText(person.getAddress());
                jtfPhone.setText("" + person.getPhone());
                jtfEmail.setText(person.getEmail());
            }
        }

    }

    public void displayNextRecord() {


        recordNumber++;

        if (recordNumber >= personsList.size()) {
            JOptionPane.showMessageDialog(null, "تمام نتایج نشان داده شد.");

            jbnForward.setEnabled(false);
            jbnBack.setEnabled(true);


            recordNumber--;
        } else {
            jbnBack.setEnabled(true);
            PersonEnti person = (PersonEnti) personsList.get(recordNumber);

            jtfName.setText(person.getName());
            jtfAddress.setText(person.getAddress());
            jtfPhone.setText("" + person.getPhone());
            jtfEmail.setText(person.getEmail());
        }
    }


    public void displayPreviousRecord() {


        recordNumber--;

        if (recordNumber < 0) {
            JOptionPane.showMessageDialog(null, "تمام نتایج نشان داده شد. " );


            jbnForward.setEnabled(true);
            jbnBack.setEnabled(false);


            recordNumber++;
        } else {
            jbnForward.setEnabled(true);
            PersonEnti person = (PersonEnti) personsList.get(recordNumber);


            jtfName.setText(person.getName());
            jtfAddress.setText(person.getAddress());
            jtfPhone.setText("" + person.getPhone());
            jtfEmail.setText(person.getEmail());
        }

    }

    public void clear() {

        jtfName.setText("");
        jtfAddress.setText("");
        jtfPhone.setText("");
        jtfEmail.setText("");


        recordNumber = -1;
        personsList.clear();
        jbnForward.setEnabled(true);
        jbnBack.setEnabled(true);
    }


}
