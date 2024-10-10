package core.basesyntax.service.report;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitRecord;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport(List<FruitRecord> fruitRecords) {
        StringBuilder report = new StringBuilder();
        report.append(FRUIT).append(COMMA).append(QUANTITY).append(System.lineSeparator());
        if (fruitRecords.isEmpty() && Storage.storage.isEmpty()) {
            return report.toString();
        }

        for (FruitRecord record : fruitRecords) {
            report.append(record.getFruit()).append(COMMA)
                    .append(record.getQuantity()).append(System.lineSeparator());
        }

        Storage.storage.forEach((fruit, quantity) -> report
                .append(fruit).append(COMMA).append(quantity).append(System.lineSeparator()));
        return report.toString();
    }
}
