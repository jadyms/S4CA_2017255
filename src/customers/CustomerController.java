package customers;

import init.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import rental.CreateRentalView;

/**
 *
 * @author JadyMartins
 */

public class CustomerController implements ActionListener, ListSelectionListener {

    //This controller is accessing most of the classes
   
    Customer newCustomer;
    AddCustomerView addCustomerView;
    ManageCustomerView manageCustomerView;
    CustomerModel customerModel;
    HomeView homeView;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Customer")) {

            //add a new customer
            //display the form with empty fields
            AddCustomerView createCustomer = new AddCustomerView();
            createCustomer.addCustomer("", "", "", "");

        } else if (e.getActionCommand().equals("Manage existing customer")) {
            //Display all the customers in the array
            ManageCustomerView manageCustomer = new ManageCustomerView();
            manageCustomer.populateTable();

        } else if (e.getActionCommand().equals("Submit")) {

            //add the new customer to the array of customers
            
            //creating a instance of customer class
            addCustomerView = new AddCustomerView();

            //generate a loyalty number
            //from the last number created
            int last = Integer.parseInt(customerModel.users.get(customerModel.users.size() - 1).getLoyaltyNumber()) + 1;
          
            //create a new customer and add it to array
            customerModel.users.add(new Customer(
                    addCustomerView.getFirstName(),
                    addCustomerView.getLastName(),
                    addCustomerView.getSubscriptionType(),
                    addCustomerView.getCard(),
                    String.valueOf(last),
                    "0" //starts with 0 titles rented
            ));

             JOptionPane.showMessageDialog(null, "Customer created. You can manage details in Manage Customer");

        } else if (e.getActionCommand().equals("Create Rental")) {
            //####### CREATE RENTAL CODE IS IN LIST SELECTION EVENT #######

//               RentalModel rentalModel = new RentalModel();
//                        
//               
//               
//               if ( rentalModel.getRental(manageCustomerView.getLoyaltyNumber()).size()>=4){
//              
//              //JDialog to display information below
//              System.out.println("You cant rent any more titles");
//              
//              
//          } else{
//               
//            ManageCustomerView manageCustomer = new ManageCustomerView();
//            manageCustomer.populateTable();
//            
//            }
//        
        }
    }

    //When a customer is selected
    //It means when a row is selected from the JTable
    @Override
    public void valueChanged(ListSelectionEvent e) {

        Customer customer = new Customer();

        int row = manageCustomerView.table.getSelectedRow();
        String fname = (String) manageCustomerView.table.getValueAt(row, 0);
        String lname = (String) manageCustomerView.table.getValueAt(row, 1);
        String subscription = (String) manageCustomerView.table.getValueAt(row, 2);
        String card = (String) manageCustomerView.table.getValueAt(row, 3);
        String loyalty_number = (String) manageCustomerView.table.getValueAt(row, 4);
        String hold = (String) manageCustomerView.table.getValueAt(row, 5);
        String message = (fname + " " + lname);
        
        //When row is selected:    

        Object[] options = {"Update Customer", "Create Rental", "Manage Rental"};
        int n = JOptionPane.showOptionDialog(null,
                "Update " + message + " info",
                "Select an option for the user",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        //if create rental
        switch (n) {
            case 1: {
     
                manageCustomerView = new ManageCustomerView();
                //show panel with customer information 
                CreateRentalView createRental = new CreateRentalView(
                        manageCustomerView.getFirstName(),
                        manageCustomerView.getLastName(),
                        manageCustomerView.getLoyaltyHold(),
                        manageCustomerView.getLoyaltyNumber(),
                        manageCustomerView.getSubscription()
                );

                //manageRental.populateTable(loyalty_number);
//                    RentalModel rentalModel = new RentalModel();
//                    if ( rentalModel.getRental((String) manageCustomerView.table.getValueAt(row, 4)).size()>=4){
//                        //   if ( rentalModel.allRental((String) manageCustomerView.table.getValueAt(row, 4)).size()>=4){
//                        JOptionPane.showMessageDialog (null,
//                                "Customer have reached 4 titles rented. Select the option - Manage rental - to return titles" ,
//                                "You cannot rent any more titles",
//                                JOptionPane.ERROR_MESSAGE);
//                        
//                    }else{
//                        
//                        manageCustomerView = new ManageCustomerView();
//                        
//                        CreateRentalView createRental = new CreateRentalView(
//                                manageCustomerView.getFirstName(),
//                                manageCustomerView.getLastName(),
//                                manageCustomerView.getLoyaltyHold(),
//                                manageCustomerView.getLoyaltyNumber(),
//                                manageCustomerView.getSubscription());
//                        
            }
            break;

            //} 
            //if update customer
            //Code not correct 
            case 0:
                customer.FillCustomerForm(fname, lname, subscription, card, loyalty_number);
                int x = customerModel.users.indexOf(loyalty_number) + 1;
                customerModel.users.set(x, new Customer(
                        fname,
                        lname,
                        subscription,
                        card,
                        loyalty_number,
                        hold
                ));

                //manageCustomerView.getFirstName(),
                //manageCustomerView.getLastName(),
                //manageCustomerView.getSubscription(),
                //manageCustomerView.getCard());
                break;
            case 2: {
                System.out.println("Not developed");

                break;
            }
            default:
                break;
        }

    }

}
