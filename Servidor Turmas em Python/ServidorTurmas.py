#coding :utf-8

import socket
import json
import os

porta = 5000
tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
tcp.bind(("",porta))
tcp.listen(1)
while True:
	print("Aguardando conexao...")
	con, cliente = tcp.accept()
	while True:
		os.system("cls")
		print ("Cliente conectado:",cliente)
		msg = con.recv(2048).decode('utf-8')
		jturma = json.loads(msg)
		for value in jturma:
			turma = value["ID"]
			ano_turma = value["Ano"]
			nome_curso = value["Curso"]
			qtd_alunos_matriculados_turma = 0
			qtd_alunos_turma = len(value["Alunos"])
			for aluno in value["Alunos"]:
				if aluno["Matriculado"] == "True":
					qtd_alunos_matriculados_turma = qtd_alunos_matriculados_turma+1
			print("A turma ",turma, " de ", ano_turma, " do curso ", nome_curso, " possui ", qtd_alunos_turma ," alunos, dos quais ", qtd_alunos_matriculados_turma, " estão devidamente matriculados.")
		break
tcp.close()