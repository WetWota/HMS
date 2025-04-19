package project.hms.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import project.hms.models.BookingData;
import project.hms.models.BookingTableModel;
import project.hms.services.BookingService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class BookingTablePanel extends JPanel {
    private JTable table;
    private BookingService service;

    public BookingTablePanel() {
        service = new BookingService();
        setLayout(new java.awt.BorderLayout());

        setBackground(new Color(45, 45, 45));
        
        List<BookingData> bookingList = loadAllBookings();
        BookingTableModel model = new BookingTableModel(bookingList);

        table = new JTable(model);
        
        table.setBackground(new Color(60, 63, 65));
        table.setForeground(Color.WHITE);
        table.setGridColor(new Color(80, 80, 80));
        table.setSelectionBackground(new Color(75, 110, 175));
        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(50, 50, 50));
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(Font.BOLD));

        setColumnWidths();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        int viewportWidth = 400;
        int viewportHeight = 400;
        scrollPane.getViewport().setPreferredSize(new Dimension(viewportWidth, viewportHeight));
        
        
        scrollPane.setPreferredSize(new Dimension(
            viewportWidth + scrollPane.getVerticalScrollBar().getPreferredSize().width,
            viewportHeight + scrollPane.getHorizontalScrollBar().getPreferredSize().height
        ));
        scrollPane.getViewport().setBackground(new Color(45, 45, 45));
        
        UIManager.put("ScrollBar.thumb", new Color(80, 80, 80));
        UIManager.put("ScrollBar.track", new Color(40, 40, 40));
        UIManager.put("ScrollBar.width", 12);


        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(80, 80, 80);
                this.trackColor = new Color(40, 40, 40);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return invisibleButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return invisibleButton();
            }

            private JButton invisibleButton() {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(0, 0));
                btn.setMinimumSize(new Dimension(0, 0));
                btn.setMaximumSize(new Dimension(0, 0));
                return btn;
            }
        });

        scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(80, 80, 80);
                this.trackColor = new Color(40, 40, 40);
            }
        });
        add(scrollPane, java.awt.BorderLayout.CENTER);
    }

    private void setColumnWidths() {
        JTableHeader header = table.getTableHeader();
        
        int[] columnWidths = {
            50,   // Booking ID
            120,  // Patient Name
            120,  // Staff Name
            70,  // Appointment Date
            70,  // Appointment Time
            75,  // Status
            75,  // Handler
            70,  // Created On
            70   // Created Time
        };
        
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        
        table.setRowHeight(20);
    }
    
    private List<BookingData> loadAllBookings() {
        List<BookingData> bookings = new ArrayList<>();
        try (var reader = new com.opencsv.CSVReader(new java.io.FileReader("csv/bookingData.csv"))) {
            String[] line;
            reader.readNext(); // skip header
            var formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
            var timeFormat = java.time.format.DateTimeFormatter.ofPattern("hh a");

            while ((line = reader.readNext()) != null) {
                bookings.add(new BookingData(
                        Integer.parseInt(line[0]),
                        Integer.parseInt(line[1]),
                        Integer.parseInt(line[2]),
                        java.time.LocalDate.parse(line[3], formatter),
                        java.time.LocalTime.parse(line[4], timeFormat),
                        line[5],
                        line[6],
                        java.time.LocalDate.parse(line[7], formatter),
                        java.time.LocalTime.parse(line[8], timeFormat)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
