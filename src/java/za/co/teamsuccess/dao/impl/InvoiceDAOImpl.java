package za.co.teamsuccess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.teamsuccess.dao.InvoiceDAO;
import za.co.teamsuccess.manager.DBPoolManagerBasic;

public class InvoiceDAOImpl implements InvoiceDAO {
    Connection con;
    PreparedStatement ps;
    PreparedStatement ps1;
    ResultSet rs;
    private final DBPoolManagerBasic dbManager;

    public InvoiceDAOImpl(DBPoolManagerBasic dbManager) {
        this.dbManager = dbManager;
    }
    
//***********************************************************************************************************
    @Override
    public int getLastInvoiceNumber() {
        int  invoiceId = 0;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("SELECT lastid FROM lastidtable WHERE keyid='invoiceNo'");
            rs = ps.executeQuery();
            if(rs.next()){
              invoiceId = rs.getInt("lastid");
            }
        } catch (SQLException ex) {
            System.out.println("Error getting invoice from database : " + ex.getMessage());
        }finally{
            closeStreams();
        }
        return invoiceId;
    }
//***********************************************************************************************************
    @Override
    public boolean updateInvoiceNumber(int invoiceNumber) {
        boolean retVal=false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("UPDATE lastidtable SET lastid=? WHERE keyid='invoiceNo'");
            ps.setInt(1, invoiceNumber);
            if(ps.executeUpdate()>0){
              retVal=true;
            }
        } catch (SQLException ex) {
            System.out.println("Error updating invoice number in database : " + ex.getMessage());
        }finally{
            closeStreams();
        }
        return retVal;
    }
//***********************************************************************************************************
    private void closeStreams() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Error closing ResultSet: " + ex.getMessage());
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Error closing prepared statement: " + ex.getMessage());
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            }
        }
        rs = null;
        ps = null;
        con = null;
    }

    
}