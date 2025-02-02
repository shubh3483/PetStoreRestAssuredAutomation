package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider (name = "Data")
    public String[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "//testdata//Userdata.xlsx";
        XLUtility utility = new XLUtility();
        int rowNum = utility.getRowCount(path,"Sheet1");
        int colNum = utility.getCellCount(path,"Sheet1", 1);

        String [][] apidata = new String[rowNum][colNum];
        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                apidata[i-1][j] = utility.getCellData(path,"Sheet1", i, j);
            }
        }
        return apidata;
    }

    @DataProvider (name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir") + "//testdata//Userdata.xlsx";
        XLUtility utility = new XLUtility();
        int rowNum = utility.getRowCount(path,"Sheet1");

        String [] apidata = new String[rowNum];
        for (int i = 1; i <= rowNum; i++) {
            apidata[i-1] = utility.getCellData(path,"Sheet1", i, 1);
        }

        return apidata;
    }
}
