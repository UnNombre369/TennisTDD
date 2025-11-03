sonar-up:
	docker compose up -d

sonar-down:
	docker compose down

sonar-remove:
	docker compose down -v

sonar-analyze:
	mvn clean verify sonar:sonar -Dsonar.token=AQUI_TU_TOKEN