CREATE TABLE Curso (
  idCurso SERIAL  NOT NULL ,
  nome VARCHAR(45)      ,
PRIMARY KEY(idCurso));



CREATE TABLE Aluno (
  matricula SERIAL  NOT NULL ,
  senha VARCHAR(20)      ,
PRIMARY KEY(matricula));



CREATE TABLE Disciplina (
  idDisciplina SERIAL  NOT NULL ,
  Curso_idCurso INTEGER   NOT NULL ,
  nome VARCHAR(45)    ,
  periodo INTEGER    ,
  tipo VARCHAR(20)      ,
PRIMARY KEY(idDisciplina),
  FOREIGN KEY(Curso_idCurso)
    REFERENCES Curso(idCurso));




CREATE TABLE AlunoMatriculado (
  Aluno_matricula INTEGER   NOT NULL ,
  Curso_idCurso INTEGER   NOT NULL   ,
PRIMARY KEY(Aluno_matricula, Curso_idCurso),
  FOREIGN KEY(Aluno_matricula)
    REFERENCES Aluno(matricula),
  FOREIGN KEY(Curso_idCurso)
    REFERENCES Curso(idCurso));



CREATE TABLE Album (
  idAlbum SERIAL  NOT NULL ,
  AlunoMatriculado_Aluno_matricula INTEGER   NOT NULL ,
  Disciplina_idDisciplina INTEGER   NOT NULL ,
  AlunoMatriculado_Curso_idCurso INTEGER   NOT NULL ,
  descricao VARCHAR(45)    ,
  dataCriacao DATE      ,
PRIMARY KEY(idAlbum),
  FOREIGN KEY(AlunoMatriculado_Aluno_matricula, AlunoMatriculado_Curso_idCurso)
    REFERENCES AlunoMatriculado(Aluno_matricula, Curso_idCurso),
  FOREIGN KEY(Disciplina_idDisciplina)
    REFERENCES Disciplina(idDisciplina));



CREATE TABLE Foto (
  idFoto SERIAL  NOT NULL ,
  AlunoMatriculado_Aluno_matricula INTEGER   NOT NULL ,
  Disciplina_idDisciplina INTEGER   NOT NULL ,
  Album_idAlbum INTEGER   NOT NULL ,
  AlunoMatriculado_Curso_idCurso INTEGER   NOT NULL ,
  permissao BOOL  DEFAULT FALSE  ,
  dataCriacao DATE      ,
PRIMARY KEY(idFoto),
  FOREIGN KEY(AlunoMatriculado_Aluno_matricula, AlunoMatriculado_Curso_idCurso)
    REFERENCES AlunoMatriculado(Aluno_matricula, Curso_idCurso),
  FOREIGN KEY(Album_idAlbum)
    REFERENCES Album(idAlbum),
  FOREIGN KEY(Disciplina_idDisciplina)
    REFERENCES Disciplina(idDisciplina));




