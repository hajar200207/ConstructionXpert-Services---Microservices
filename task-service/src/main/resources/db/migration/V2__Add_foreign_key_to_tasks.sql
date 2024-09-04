ALTER TABLE tasks
    ADD CONSTRAINT fk_project
        FOREIGN KEY (project_id) REFERENCES projects(id);
