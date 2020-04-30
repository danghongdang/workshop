
grammar SQLStatement;

import Symbol, Keyword, Literals;

use
    : USE schemaName
    ;
    
schemaName
    : identifier
    ;
    
insert
    : INSERT INTO? tableName columnNames? VALUE assignmentValues
    ;
  
assignmentValues
    : LP_ assignmentValue (COMMA_ assignmentValue)* RP_
    ;

assignmentValue
    : identifier
    ;
    
columnNames
    : LP_ columnName (COMMA_ columnName)* RP_
    ;

columnName
    : identifier
    ;
   
tableName
    : identifier
    ;
    
identifier
    : IDENTIFIER_ | STRING_ | NUMBER_
    ;

select
    : SELECT selectColumnNames FROM tableName (WHERE whereColumnNameAndValues)?
    ;

selectColumnNames
    : (columnName (COMMA_ columnName)*) || ASTERISK_
    ;

whereColumnNameAndValues
    : whereColumnName EQ_ whereColumnValue (AND whereColumnName EQ_ whereColumnValue)*
    ;

whereColumnName
    : identifier
    ;

whereColumnValue
    : identifier
    ;

update
    : UPDATE tableName SET updateColumnNameAndValues (WHERE whereColumnNameAndValues)?
    ;

updateColumnNameAndValues
    : columnName EQ_ updateColumnValue (COMMA_ columnName EQ_ updateColumnValue)*
    ;

updateColumnValue
    : identifier
    ;
