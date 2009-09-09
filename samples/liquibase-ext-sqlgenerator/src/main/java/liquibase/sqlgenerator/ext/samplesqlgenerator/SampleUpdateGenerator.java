package liquibase.sqlgenerator.ext.samplesqlgenerator;

import liquibase.database.Database;
import liquibase.exception.ValidationErrors;
import liquibase.sql.Sql;
import liquibase.sql.UnparsedSql;
import liquibase.sqlgenerator.SqlGenerator;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.statement.core.UpdateStatement;

public class SampleUpdateGenerator implements SqlGenerator<UpdateStatement> {
    public int getPriority() {
        return 15;
    }

    public boolean supports(UpdateStatement statement, Database database) {
        return true;
    }

    public ValidationErrors validate(UpdateStatement statement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        return new ValidationErrors();
    }

    public Sql[] generateSql(UpdateStatement statement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        return new Sql[] {
                new UnparsedSql("select "+database.getCurrentDateTimeFunction())
        };
    }
}