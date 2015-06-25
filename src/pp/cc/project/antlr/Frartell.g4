grammar Frartell;

@header{package pp.cc.project.antlr;}

/** Program **/
program
 : (stat | decl | declfunc)* EOF
 ;

/** Statement **/
stat
 : target ASSIGN expr SEMCOL                        #assignStat
 | IF OPAR expr CPAR block (ELSE block)?            #ifStat
 | <assoc=right> expr QMARK expr COLON expr SEMCOL  #ternStat
 | WHILE OPAR expr CPAR block                       #whileStat
 | ID args SEMCOL                                   #funcCalltStat
 | RETURN expr SEMCOL                               #returnStat
 ;

/** Expression **/
expr
 : MINUS expr                             #unaryMinExpr
 | NOT expr                               #notExpr
 | ID args                                #funcCalltExpr
 | expr op=(MULT | DIV | MOD) expr        #multExpr
 | expr POW expr                          #powExpr
 | expr op=(PLUS | MINUS) expr            #addExpr
 | expr op=(EQ | NEQ) expr                #eqExpr
 | expr op=(LW | GR | GREQ | LWEQ) expr   #compExpr
 | expr op=(AND | OR) expr                #boolExpr
 | ID OSQ expr CSQ                        #indexExpr
 | OSQ (expr (COMMA expr)*)? CSQ          #arrayExpr
 | atom                                   #atomExpr
 ;

/** Assignment target **/
target
 : ID                #idTarget
 | ID OSQ expr CSQ   #arrayTarget
 ;

/** Declaration **/
decl
 : type decltarget (ASSIGN expr)? SEMCOL
 ;

declfunc
 : DEF ID pars block
 ;

/** Declaration target **/
decltarget
 : ID                    #idDeclTarget
 | ID OSQ INTEGER CSQ    #arrayDeclTarget
 ;

/** block **/
block
 : OBRACE (stat | decl)* CBRACE
 ;

/** Arguments of a function call */
args
 : OPAR (expr (COMMA expr)*)? CPAR
 ;

/** Parameters of a function declaration */
pars
 : OPAR (type ID (COMMA type ID)*)? CPAR
 ;

/** Atomic value **/
atom
 : OPAR expr CPAR   #parExprAtom
 | INTEGER          #intAtom
 | (TRUE | FALSE)   #boolAtom
 | ID               #idAtom
 | STRING           #stringAtom
 ;

/** Data type **/
type
 : INT      #intType
 | BOOL     #boolType
 | STR      #stringType
 ;

/** Keywords **/
TRUE:     'True';
FALSE:    'False';
IF:       'if';
ELSE:     'else';
WHILE:    'while';
INT:      'int';
BOOL:     'bool';
STR:      'String';
DEF:      'def';
RETURN:   'return';

/** Operators **/
MINUS:    '-';
POW:      '^';
MOD:      '%';
PLUS:     '+';
DIV:      '/';
MULT:     '*';
GREQ:     '>=';
LWEQ:     '<=';
GR:       '>';
LW:       '<';
AND:      '&&';
OR:       '||';
EQ:       '==';
NEQ:      '!=';
NOT:      '!';
ASSIGN:   '=';
DOT:      '.';
QMARK:    '?';
COLON:    ':';

/** Syntactic tokens **/
OPAR:     '(';
CPAR:     ')';
OBRACE:   '{';
CBRACE:   '}';
OSQ:      '[';
CSQ:      ']';
SEMCOL:   ';';
COMMA:    ',';

/** Content-bearing tokens **/
ID
 : [a-zA-Z] ([a-zA-Z_] | [0-9])*
 ;
INTEGER
 : '0' | ([1-9] [0-9]*)
 ;
STRING
 : '"' .*? '"'
 ;

/** Skipped tokens **/
COMMENT
 : '//' ~[\r\n]* -> skip
 ;
BLOCKCOMMENT
 : '/*' .*? '*/' -> skip
 ;
WS
 : [ \t\n\r] -> skip
 ;