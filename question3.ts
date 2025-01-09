/*
Describe your experience with Angular, including its core features and use cases. Provide
an example of a practical application where you used Angular and include a code snippet
demonstrating a key feature, such as component communication, data binding, or
service integration.
*/

@Input() task: { id: number; name: string };
@Output() delete = new EventEmitter<number>();
deleteTask() {
  this.delete.emit(this.task.id);
}
